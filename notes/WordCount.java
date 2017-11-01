import java.util.ArrayList;
import java.util.Collection;

public class WordCount {
    private ArrayList<String> words;
    private int numwords;

    public WordCount(String fileName) {
        words = new ArrayList<String>(3);
        words.add("Happy");
        words.add("Halloween");
        words.add("Candy");
        numwords = 3;
    }

    public Collection<String> getWords() {
        return words;
    }

    public int getCount(String word) {
        return 1;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word : wc.getWords()) {
            System.out.printf("%s: %d \n", word, wc.getCount(word));
        }
    }
}
