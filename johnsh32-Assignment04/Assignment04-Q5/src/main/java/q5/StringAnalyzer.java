package q5;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyzer {

    private String cleanedString;

    // constructor cleans input and initializes cleanedString
    public StringAnalyzer(String input) {
        StringCleaner stringCleaner = new StringCleaner();
        this.cleanedString = stringCleaner.cleanString(input);
    }

    // calculates the frequency of each word in cleanedString
    // and returns map of frequencies of words
    public Map<String, Integer> getWordFrequencies() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = cleanedString.split(" ");

        for (String word : words) {
            // increment frequency of each word for every occurence, each starting at 0
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    // finds and returns longest word in cleanedString
    public String getLongestWord() {
        if (cleanedString.isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot find the longest word.");
        }

        String longestWord = "";
        for (String word : cleanedString.split(" ")) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    // checks if cleanedString is a palindrome,
    // ignoring spaces and letter case
    public boolean isPalindrome() {
        if (cleanedString.isEmpty()) {
            throw new ArithmeticException("String is empty. Cannot perform palindrome check.");
        }

        // ignore white space
        String normalized = cleanedString.replaceAll(" ", "");
        int left = 0;
        int right = normalized.length() - 1;

        // start at both sides of normalized string,
        // checking that characters match, moving to the middle
        while (left < right) {
            if  (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        // all characters matched, must be palindrome
        return true;
    }

    public String getCleanedString() {
        return cleanedString;
    }
}
