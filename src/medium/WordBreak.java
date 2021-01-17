package medium;

import java.util.List;
import java.util.Map;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        return isPossibleByRecursion(s, wordDict);
    }

    boolean isPossibleByMemo(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (s.isEmpty()) return true;

        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                boolean isPossible = isPossibleByMemo(suffix, wordDict, memo);
                memo.put(suffix, isPossible);
                if (isPossible) {
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    /**
     * By recursive solution
     */
    boolean isPossibleByRecursion(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                if (isPossibleByRecursion(suffix, wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }
}
