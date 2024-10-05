package parser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		String pathname = "input/nilsholg.txt";
		Scanner s = ScannerFactory.scannerForNaturalLanguage(pathname);

		TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new SingleWordCounter("nils"), new SingleWordCounter("norge")});
		String report = analyzer.analyzeText(s);
		System.out.println(report);
	}

}