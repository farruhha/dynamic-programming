package easy;

import java.util.Map;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        return isPossibleByRecursion(s, t);
    }

    /**
     * Worse case recursive solution
     * */
    private boolean isPossibleByRecursion(String s, String t) {
        if (s.equals(t)) return true;
        for (int index = 0; index < t.length(); index++) {
            StringBuilder next = new StringBuilder(t);
            if (isSubsequence(s, next.deleteCharAt(index).toString())) {
                return true;
            }
        }
        return false;
    }

    /***
     * By memoization
     * */
    private boolean isPossibleByMemo(String s, String t, Map<String, Boolean> memo){
        if(memo.containsKey(t)) return memo.get(t);
        if(s.equals(t)) return true;
        for(int index = 0; index < t.length(); index++){
            StringBuilder next = new StringBuilder(t);
            String sub = next.deleteCharAt(index).toString();
            boolean isSequence = isPossibleByMemo(s, sub, memo);
            memo.put(sub, isSequence);
            if(isSequence){
                return true;
            }
        }
        memo.put(t, false);
        return false;
    }


    /**
     * Simple iteration **/
    private boolean byTraverse(String s, String t){
        int initial = -1;
        for(int index = 0; index < s.length(); index++){
            char element = s.charAt(index);
            Sub sub = isSub(initial, element, t);
            if(!sub.is) return false;
            initial = sub.index;
        }
        return true;
    }

    private Sub isSub(int initial, char element, String t){
        if(initial + 1 >= t.length()) return new Sub(initial + 1, false);

        for(int index = initial + 1; index < t.length(); index++){
            if(t.charAt(index) == element){
                return new Sub(index, true);
            }
        }
        return new Sub(t.length(), false);
    }

    class Sub{
        int index;
        boolean is;

        public Sub (int index, boolean is){
            this.index = index;
            this.is = is;
        }
    }


}
