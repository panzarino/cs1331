import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCount {
    private Map<String, Integer> wordCounts;
    private int numwords;

    public WordCount(String fileName) throws FileNotFoundException {
        wordCounts = new HashMap<String, Integer>();
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNext()) {
            String word = fileScanner.next().toLowerCase().replaceAll("[^a-z]", "");
            if (wordCounts.get(word) != null) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
            numwords++;
        }
    }

    public Set<String> getWords() {
        return wordCounts.keySet();
    }

    public int getCount(String word) {
        return wordCounts.get(word);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word : wc.getWords()) {
            System.out.printf("%s: %d \n", word, wc.getCount(word));
        }
    }
}
