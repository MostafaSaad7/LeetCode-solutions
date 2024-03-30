import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // number , count
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (hashMap.containsKey(number)) {
                int count = hashMap.get(number) + 1;
                hashMap.put(number,count);
                    while (hashMap.get(number) > k && left < nums.length) {
                        int startingNumCount = hashMap.get(nums[left]);
                        startingNumCount--;
                        hashMap.put(nums[left], startingNumCount);
                        left++;
                    }
                
            } else {
                hashMap.put(number, 1);
            }

            res = Math.max(res, (i - left + 1));
        }


        return res;
    }
}