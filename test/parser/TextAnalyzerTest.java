package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextAnalyzerTest {

    @Test
    @DisplayName("Can find Nils in nils.txt ")
    void analyzeText() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils.txt");
        TextProcessor[] textProcessor = {new SingleWordCounter("nils")};
        TextAnalyzer analyzer = new TextAnalyzer(textProcessor);
        assertEquals("nils: 2", analyzer.analyzeText(scanner));
    }

    @Test
    @DisplayName("Can find two nils and three norway in nils_norway.txt")
    void analyzeText2() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils_norway.txt");
        TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new SingleWordCounter("nils"), new SingleWordCounter("norge")});
        assertEquals("nils: 3\nnorge: 2", analyzer.analyzeText(scanner));
    }
    void analyzeText3() throws FileNotFoundException {
        Scanner scanner = ScannerFactory.scannerForNaturalLanguage("test_data/nils_norway.txt");
        TextAnalyzer analyzer = new TextAnalyzer(new TextProcessor[] {new SingleWordCounter("nils"), new SingleWordCounter("norge")});
        assertEquals("nils: 3\nnorge: 2", analyzer.analyzeText(scanner));
    }

}