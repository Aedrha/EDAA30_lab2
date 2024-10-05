package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextAnalyzerPerformanceTest{
	 private static final String NILS_HOLG_PATH = "input/nilsholg.txt";
	 private static final String MINDUSTRY_PATH = "input/mindustry.txt";
	 private Set<String> holgerssonStopWords;
	 private Set<String> mindustryStopWords; 

	    @BeforeEach
	    void setUp() throws FileNotFoundException {
	        // Initiera stoppord för Holgersson
	        String[] holgerssonNoNoWord = StopWordParser.parse("input/undantagsord.txt");
	        holgerssonStopWords = new HashSet<>();
	        for (String word : holgerssonNoNoWord) {
	            holgerssonStopWords.add(word);
	        }

	        // Initiera stoppord för Mindustry
	        String[] mindustryNoNoWord = StopWordParser.parse("input/reserved.txt");
	        mindustryStopWords = new HashSet<>();
	        for (String word : mindustryNoNoWord) {
	            mindustryStopWords.add(word);
	        }
	    }
	private void runPerformanceTest(String path, Set<String> s, boolean holg, boolean sorted) throws FileNotFoundException {
		 	Scanner scan = holg ? ScannerFactory.scannerForNaturalLanguage(path) : ScannerFactory.scannerForCode(path);
		 	GeneralWordCounter gWC = sorted ? new SortedGeneralWordCounter(s) : new GeneralWordCounter(s);
		 	long startTime = System.nanoTime();
			TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {gWC});
			
			String report = analyzer.analyzeText(scan);
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			System.out.println("Exekveringstid: " + duration + " nanosekunder");
		
	}
	@Test
    void PreformanceTest1() throws FileNotFoundException {
        runPerformanceTest(NILS_HOLG_PATH, holgerssonStopWords, true, false);
    }
    @Test
    void PreformanceTest2() throws FileNotFoundException {
    	runPerformanceTest(NILS_HOLG_PATH, holgerssonStopWords, true, true);
    }
    
    @Test
    void PreformanceTest3() throws FileNotFoundException {
    	runPerformanceTest(MINDUSTRY_PATH, mindustryStopWords, false, false);
    }
    @Test
    void PreformanceTest4() throws FileNotFoundException {
    	runPerformanceTest(MINDUSTRY_PATH, mindustryStopWords, false, true);
    }
}