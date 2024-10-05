package parser;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordsInCode {



	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "input/mindustry.txt";
		Scanner s = ScannerFactory.scannerForCode(pathname);

		
		String[] noNoWord = StopWordParser.parse("input/reserved.txt");
		Set<String> set = new HashSet<>(); 
		for(String i : noNoWord) {
			set.add(i);
		}
		//TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new GeneralWordCounter(set)});
		TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new SortedGeneralWordCounter(set)});
		String report = analyzer.analyzeText(s);
		System.out.println(report);
	}
}
