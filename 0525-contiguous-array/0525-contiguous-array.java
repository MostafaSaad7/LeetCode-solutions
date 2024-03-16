import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // prefix sum , count
        map.put(0, -1); // this is -1 index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                sum--;
            else
                sum++;
            if (map.containsKey(sum)) {

                count =Math.max(count, i-map.get(sum)); // here we count the number of ways from the current element of the array we can make this diff
            }
            if (!map.containsKey(sum))
                map.put(sum, i);

        }

        return count;
    }
}

/*
     s s
     0 1
       1,0,0,0,1,1
* [0,0,1,0,0,0,1,1,1]
* [,-1,-2,-1,-2,-3,-4,-3,-2,-1]
*
* [0,1]
  0,-1,0
* */