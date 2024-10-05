package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class SortedGeneralWordCounterTest {

    @Test
    void findWords() {
        String[] noNoWord = {""};
			Set<String> set = new HashSet<>(); 
	        Collections.addAll(set, Arrays.toString(noNoWord));
	        TextProcessor processor = new SortedGeneralWordCounter(set);
	        assertEquals("", processor.report());
    }
    @Test
    void findWords2() {
        String[] noNoWord = {""};
			Set<String> set = new HashSet<>(); 
			for(String i : noNoWord) {
				set.add(i);
			}
	        TextProcessor processor = new SortedGeneralWordCounter(set);
	        processor.process("norge");
	        processor.process("norge");
	        processor.process("nils");
	        assertEquals("norge: 2\nnils: 1", processor.report());
    }
    
    @Test
    void findWords3() {
        String[] noNoWord = {""};
			Set<String> set = new HashSet<>(); 
			for(String i : noNoWord) {
				set.add(i);
			}
	        TextProcessor processor = new SortedGeneralWordCounter(set);
	        processor.process("nils");
	        processor.process("nils");
	        processor.process("norge");
	        assertEquals("nils: 2\nnorge: 1", processor.report());
    }
}

