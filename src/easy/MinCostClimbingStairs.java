package easy;

import java.util.Map;

public class MinCostClimbingStairs {

    /**
     * Recursive solution
     */
    public int minCostClimbingStairs(int[] cost) {
        return calByRecursion(cost, -1);
    }

    private int calByMemoization(int[] costs, int index, Map<Integer, Integer> memo) {
        if (memo.containsKey(index)) return memo.getOrDefault(index, 0);
        if (index >= costs.length - 2) return 0;
        int stepOne = calByMemoization(costs, index + 1, memo) + costs[index + 1];
        int stepTwo = calByMemoization(costs, index + 2, memo) + costs[index + 2];
        int min = Math.min(stepOne, stepTwo);
        memo.put(index, min);
        return min;
    }

    private int calByRecursion(int[] costs, int index) {
        if (index >= costs.length - 2) return 0;
        return Math.min(calByRecursion(costs, index + 1) + costs[index + 1], calByRecursion(costs, index + 2) + costs[index + 2]);
    }
}
