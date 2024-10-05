package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiWordCounterTest {

    @Test
    void findWords() {
        String toFind = "Nils";
        //TextProcessor processor = new MultiWordCounter({toFind.toLowerCase()});
        TextProcessor processor = new MultiWordCounter(new String[] {toFind.toLowerCase()});
        assertEquals("nils: 0", processor.report());
    }
    
    @Test
    void findWords2() {
        TextProcessor processor = new MultiWordCounter(new String[] {"nils", "norge", "megatron", "skåne"});
        for(int i = 0;  i<3 ; i++) {
        	processor.process("nils");
        }
        for(int i = 0;  i<2 ; i++) {
        	processor.process("norge");
        }
        processor.process("kebab");
        processor.process("skåne");
        assertEquals("megatron: 0\nnils: 3\nnorge: 2\nskåne: 1", processor.report());
    }

}