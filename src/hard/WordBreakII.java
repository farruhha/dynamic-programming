package hard;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> sentences = generatePossibleByRecursion(s, wordDict);

        List<String> result = new ArrayList<>();
        for (List<String> words: sentences){
            String sentence = form(words);
            result.add(sentence);

        }
        return result;
    }

    private String form(List<String> words) {
        StringBuilder result = new StringBuilder();
        for (String word : words){
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    private List<List<String>> generatePossibleByRecursion(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                List<List<String>> suffixWays = generatePossibleByRecursion(suffix, wordDict);
                List<List<String>> targetWays = addWord(suffixWays, word);
                result.addAll(targetWays);
            }
        }

        return result;
    }

    private List<List<String>> addWord(List<List<String>> suffixWays, String word) {
        for (List<String> words: suffixWays){
            words.add(word);
        }
        return suffixWays;
    }
}
