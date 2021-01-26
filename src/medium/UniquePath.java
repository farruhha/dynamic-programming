package medium;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        return calculateByTabulation(m, n);
    }

    /**
     * By tabulation methods*/
    private int calculateByTabulation(int m, int n){
        int[][] tables = new int[m + 1][n + 1];
        tables[1][1] = 1;

        for (int vertical = 1; vertical <=m; vertical++){
            for (int horizontal = 1; horizontal <= n; horizontal++){
               tables[vertical][horizontal] =  getValue(vertical, horizontal, tables);
            }
        }
        return tables[m][n];
    }

    private int getValue(int vertical, int horizontal, int[][] tables) {
        return tables[vertical][horizontal] + tables[vertical - 1][horizontal] + tables[vertical][horizontal - 1];
    }

    /**
     * By memoization, using dynamic programming
     * */
    private int calculateByDpMemo(int m, int n, Map<String, Integer> memo){
        String key = m+","+n;
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        memo.put(key, calculateByDpMemo(m - 1, n, memo) + calculateByDpMemo(m, n - 1, memo));
        return memo.get(key);
    }
}
