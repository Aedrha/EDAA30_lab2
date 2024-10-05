package parser;
public class SingleWordCounter implements TextProcessor {
	private final String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}
	//1.a w.eaquals här
	public void process(String w) {
		if (w.equals(this.word)) {
			n++;
		}
	}

	public String report() {
		return word + ": " + n + "\n";
	}

}
