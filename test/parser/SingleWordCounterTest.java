package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleWordCounterTest {
/*
 * 1 a. Anledningen till att det blir knas om man inte använder equals i SingelWordCounter är att == jämför REFERENSER
 * och inte strängens innehåll. Equals jämför stärngarnas innehåll. 
 * Det blir problem för att Java har en mekanism som kallas string interning. Kortfattat är det en optimering som innebär att om två
 * identiska strängar deklareras så hamnar de i en "string pool" och får samma referens. Detta för att spara minne.
 */
    @Test
    void findNils() {
        String toFind = "Nils";
        String toProcess = "nils";
        TextProcessor processor = new SingleWordCounter( toFind.toLowerCase());
        processor.process(toProcess);
        assertEquals("nils: 1", processor.report());
    }
    @Test
    void findNils2() {
        String toFind = "nils";
        String toProcess = "nils";
        TextProcessor processor = new SingleWordCounter(toFind);
        processor.process(toProcess);
        assertEquals("nils: 1", processor.report());
    }
}