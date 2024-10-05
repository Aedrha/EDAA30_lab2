package parser;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "input/nilsholg.txt";
		Scanner s = ScannerFactory.scannerForNaturalLanguage(pathname);
		//TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new SingleWordCounter("nils"), new SingleWordCounter("norge")});
		//TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new MultiWordCounter(REGIONS)});
		
		String[] noNoWord = StopWordParser.parse("input/undantagsord.txt");
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