package q5;

import java.util.*;

public class TextAnalyzer extends StringAnalyzer {

    // constructor cleans input and initializes cleanedString
    public TextAnalyzer(String input) {
        super(input);
    }

    // calculates and returns the average word length of the string
    public double getAverageWordLength() {
        String[] words = getCleanedString().split(" ");

        // get sum of lengths of the words
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }

        // return 0 (in case of empty string) or average length
        return words.length == 0 ? 0 : (double) totalLength / words.length;
    }

    // finds and returns the most frequently recurring letter of the cleaned string,
    // returns null if cleanedString is empty
    public Character findMostFrequentLetter() {
        String cleanedString = getCleanedString();
        if (cleanedString.isEmpty()) return null;

        // creates map for each letter (key) to its frequency (value)
        Map<Character, Integer> letterFrequency = new HashMap<>();
        for (char ch : cleanedString.replaceAll(" ",  "").toCharArray()) {
            letterFrequency.put(ch, letterFrequency.getOrDefault(ch, 0) + 1);
        }

        // get max value of hashmap
        return Collections.max(letterFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // prints all words in the string in alphabetical order,
    // duplicate words only printed once
    public void printAlphabeticalOrder() {
        // create tree set from words of cleanedString (no duplicates)
        Set<String> uniqueWords = new TreeSet<>(Arrays.asList(getCleanedString().split(" ")));
        
        // print each unique word on a new line
        uniqueWords.forEach(System.out::println);
    }
}
