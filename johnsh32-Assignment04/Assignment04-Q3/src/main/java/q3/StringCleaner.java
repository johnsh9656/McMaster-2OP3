package q3;

public class StringCleaner {

    // removes all punctuation characters from input string
    private String removePunctuation(String input) {
        if (input == null) return "";
        return input.replaceAll("[\\p{Punct}]", "");
    }

    // converts entire input string to lowercase
    private String convertToLowercase(String input) {
        if (input == null) return "";
        return input.toLowerCase();
    }

    // removes leading, trailing, extra spaces in input string
    private String removeExtraSpace(String input) {
        if (input == null) return "";
        return input.trim().replaceAll("\\s+", " ");
    }

    // cleans input string by removing punctuation, 
    // converting to lowercase, and removing extra whitespace
    public String cleanString(String input) {
        if (input == null) return "";
        String noPunctuation = removePunctuation(input);
        String lowercased = convertToLowercase(noPunctuation);
        String cleanedInput = removeExtraSpace(lowercased);
        return cleanedInput;
    }
}
