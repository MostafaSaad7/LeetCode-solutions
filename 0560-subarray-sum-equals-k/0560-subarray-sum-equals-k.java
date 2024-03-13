import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // prefix sum , count
        map.put(0, 1); // this is -1 index
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            count += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}


/*
 *  1 1 1 --->
 *
 *
 * */