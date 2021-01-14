package easy;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable {

    class NumArray {

        private int [] nums;
        private Map<String, Integer> memo;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.memo = new HashMap<>();
        }

        public int sumRange(int i, int j) {
            String key = i+","+j;
            if(memo.containsKey(key)) return memo.get(key);
            int sum = calculate(i, j);
            memo.put(key, sum);
            return sum;
        }

        private int calculate(int i, int j){
            int sum = 0;
            for(int index = i; index <= j; index++){
                sum += this.nums[index];
            }
            return sum;
        }
    }
}
