package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiWordCounter implements TextProcessor{
	
	private HashMap<String, Integer> wordMap;
	private final ExecutorService executorService = Executors.newFixedThreadPool(4);;
	
	public MultiWordCounter(String[] words) {
		wordMap = new HashMap<String,Integer>();
		
		ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
		for(String w : wordList) {
			wordMap.put(w, 0);
		}
	}

	@Override
	public void process(String w) {
		if(wordMap.containsKey(w)) {
			wordMap.put(w, wordMap.get(w)+1);
		}
		
	}

	@Override
	public String report() {
		StringBuilder reportBuilder = new StringBuilder();
		wordMap.forEach((word,count)->{
			reportBuilder.append(word).append(": ").append(count).append("\n");
		});
		return reportBuilder.toString().trim();
	}
	
	
	
}