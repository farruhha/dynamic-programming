package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int result = calculateByDp(coins, amount);
        return result == -2147483648 || result == Integer.MAX_VALUE ? -1 : result;
    }

    private int calculateByMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return 0;
        int total = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remainder = amount - coin;
            if (remainder >= 0) {
                total = Math.min(calculateByMemo(coins, remainder, memo) + 1, total);
                memo.put(remainder, total);
            }
        }
        memo.put(amount, total);
        return total;
    }

    private int calculateByDp(int[] coins, int amount) {
        if (amount == 0) return 0;
        int total = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remainder = amount - coin;
            if (remainder >= 0) {
                total = Math.min(calculateByDp(coins, remainder) + 1, total);
            }
        }
        return total;
    }
}
