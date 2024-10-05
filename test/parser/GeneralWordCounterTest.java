package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class GeneralWordCounterTest {

    @Test
    void findWords() {
        String[] noNoWord = {"norge"};
			Set<String> set = new HashSet<>(); 
	        Collections.addAll(set, Arrays.toString(noNoWord));
	        TextProcessor processor = new GeneralWordCounter(set);
	        assertEquals("", processor.report());
    }
    @Test
    void findWords2() {
        String[] noNoWord = {"norge"};
			Set<String> set = new HashSet<>(); 
			for(String i : noNoWord) {
				set.add(i);
			}
	        TextProcessor processor = new GeneralWordCounter(set);
	        processor.process("norge");
	        assertEquals("", processor.report());
    }
    
    @Test
    void findWords3() {
        String[] noNoWord = {"norge"};
			Set<String> set = new HashSet<>(); 
			for(String i : noNoWord) {
				set.add(i);
			}
	        TextProcessor processor = new GeneralWordCounter(set);
	        processor.process("nils");
	        assertEquals("nils: 1", processor.report());
    }
    void findWords4() {
        String[] noNoWord = {"norge"};
			Set<String> set = new HashSet<>(); 
			for(String i : noNoWord) {
				set.add(i);
			}
	        TextProcessor processor = new GeneralWordCounter(set);
	        processor.process("nils");
	        processor.process("norge");
	        processor.process("nils");
	        assertEquals("nils: 2", processor.report());
    }

}