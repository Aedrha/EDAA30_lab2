package parser;

import java.util.HashMap;
import java.util.Set;

/*
 * Här tänker jag att man hade kunnat flertråda men då hade man nog fått göra det i Analysern.
 * Skapar en trådpool delar texten i ungefär lika stora delar och ger en GeneralWordCounter. 
 * När alla trådar är klara så adderar man alla values i en gemensam map.
*/
public class GeneralWordCounter implements TextProcessor{
	
	protected Set<String> set;
	protected HashMap<String, Integer> wordMap = new HashMap<String,Integer>();

	
	public GeneralWordCounter(Set<String> s) {
		this.set = s;
	
	}

	@Override
	public void process(String w) {
		/*
		for(String i : set) {
			System.out.println(i.equals(w));
		}
		boolean bool = set.contains(w);
		*/
		if(!set.contains(w)) {
			if(wordMap.containsKey(w)) {
				wordMap.put(w,wordMap.get(w)+1);
			}else {
				wordMap.put(w,1);
			}
		}
		
	}

	@Override
	public String report() {
		StringBuilder reportBuilder = new StringBuilder();
		  wordMap.keySet().stream()
	        .forEach(word -> { if(wordMap.get(word)>=50)
	            reportBuilder.append(word).append(": ").append(wordMap.get(word)).append("\n");
	        });
		return reportBuilder.toString().trim();
	}
	
}