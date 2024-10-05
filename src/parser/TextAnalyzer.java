package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class TextAnalyzer {

    private ArrayList<TextProcessor> processorList;

    public TextAnalyzer(TextProcessor[] textProcessor) {
        processorList = new ArrayList<>(Arrays.asList(textProcessor));
    }

    public String analyzeText(Scanner s) {
    textStream(s);
    	/*
     while (s.hasNext()) {
    	 	String w = s.next();
        	for (TextProcessor t : processorList) {
        		t.process(w.toLowerCase());	
        	}
            
        	
        } 
     
        
        s.close();
        */
        StringBuilder reportBuilder = new StringBuilder();
        for(TextProcessor t : processorList) {
        	reportBuilder.append(t.report());
        }
        return reportBuilder.toString().trim();
    }
    private void textStream(Scanner s) {
    	s.useDelimiter("[^\\p{L}]+");
    	s.tokens().map(String::toLowerCase)
    	.forEach(word-> processorList.forEach(t->t.process(word)));
    }
}