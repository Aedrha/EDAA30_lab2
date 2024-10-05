package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortedGeneralWordCounter extends GeneralWordCounter{

	public SortedGeneralWordCounter(Set<String> s) {
		super(s);
		this.wordMap = new HashMap<String,Integer>();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String report() {
		StringBuilder reportBuilder = new StringBuilder();
		  wordMap.entrySet().stream()
		  	.filter(entry -> entry.getValue() >= 0)
		  	.sorted(Map.Entry.<String,Integer>comparingByValue().reversed()) 
	        .forEach(entry -> { 
	            reportBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
	        });
		 
		return reportBuilder.toString().trim();
	}
	
}