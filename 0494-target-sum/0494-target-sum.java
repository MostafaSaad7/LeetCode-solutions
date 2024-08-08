import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] nums;
    Map<String, Integer> memory;

    public int findTargetSumWays(int[] nums, int target) {

        this.nums = nums;
        memory = new HashMap<String, Integer>();
        return dfs(0, target);
    }

    int dfs(int idx, int target) {
        if (idx == nums.length && target == 0)
            return 1;
        if (idx == nums.length)
            return 0;

        String s = idx + " " + target;
        if (memory.containsKey(s))
            return memory.get(s);


        int c1 = 0;
        int c2 = 0;
        c1 = dfs(idx + 1, target - nums[idx]);
        c2 = dfs(idx + 1, target + nums[idx]);

        memory.put(s, c1 + c2);
        return memory.get(s);

    }
}