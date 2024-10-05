package parser;

import java.util.Map;
import java.util.Set;

public class SortedGeneralWordCounter extends GeneralWordCounter{

	public SortedGeneralWordCounter(Set<String> s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String report() {
		StringBuilder reportBuilder = new StringBuilder();
		  wordMap.entrySet().stream()
		  	.filter(entry -> entry.getValue() >= 10)
		  	.sorted(Map.Entry.<String,Integer>comparingByValue().reversed()) 
	        .forEach(entry -> { 
	            reportBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
	        });
		 
		return reportBuilder.toString().trim();
	}
	
}