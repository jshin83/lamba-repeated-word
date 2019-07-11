/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lambda_repeated_word;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatedWord {
    private final static Set<Character> SPECIAL_CHARACTERS = new HashSet<>(Arrays.asList(',', '.', '!', '?', '"'));
    private static Set<String> seen;

    /**
     * Static method that checks an input String
     * and returns first wod that occurs twice.
     * Will evaluate ending punctuation
     * and is case-insensitive.
     * @param parameter String, input
     * @return String, word that occurs twice first
     */
    public static String repeated_word(String parameter) {
        seen = new HashSet<>();
        if (parameter == null || parameter.equals("")) {
            throw new IllegalArgumentException("Input is empty");
        }
        String[] words = parameter.split(" ");
        for(int i = 0; i < words.length; i++) {
            // check if word ends with special character, make lowercase
            words[i] = processWord(words[i]);
            System.out.println(words[i]);

            // check set to see if word was already seen
            // and if so, return
            if(seen.contains(words[i])) {
                return words[i];
            }
            // add to seen list
            seen.add(words[i]);
        }
        return null;
    }

    /**
     * Takes in an input String,
     * splits into array, and sorts the array.
     * Checks array two words at a time and returns if words are equal.
     * @param parameter String, input
     * @return String
     */
    public static String repeated_word_sorted(String parameter) {
        seen = new HashSet<>();
        if (parameter == null || parameter.equals("")) {
            throw new IllegalArgumentException("Input is empty");
        }

        String[] words = parameter.split(" ");
        Arrays.sort(words);

        for (int i = 0; i < words.length - 1; i++) {
            // process both word and next word
            words[i] = processWord(words[i]);
            words[i + 1] = processWord(words[i + 1]);

            if (words[i].equals(words[i + 1])) {
                return words[i];
            }
        }
        return null;
    }

    // processes word - takes off ending special character, and " character from front if it exists.
    // word to lowercase
    private static String processWord(String word) {
        // scrub any ending special characters
        if (SPECIAL_CHARACTERS.contains(word.charAt(word.length() - 1))) {
            word = word.substring(0, word.length() - 1);
        }
        // check if word starts with special character
        if(word.startsWith("\"")) {
            word = word.substring(1);
        }
        return  word.toLowerCase();
    }
}

