package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    Map<Integer, Integer> climbs = new HashMap<>();
    public int climbStairs(int n) {
        if (climbs.containsKey(n)) return climbs.get(n);
        if (n == 1 || n == 0) return 1;
        climbs.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return climbs.get(n);
    }
}
