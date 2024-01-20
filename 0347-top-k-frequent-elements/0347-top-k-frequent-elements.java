
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int [] res = new int [k];
        Arrays.stream(nums).forEach(num -> countMap.put(num, countMap.getOrDefault(num, 0) + 1));

        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1]; // array of arrayList ---> key is frequency and value is array list  of repeated objects in this length
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        int resIdx=0;
        for (int i = nums.length;i>=0;i--)
        {
            if (buckets[i]!=null)
                for (int val : buckets[i])
                {
                    res[resIdx++]=val;
                    if (resIdx==k)
                        return res;
                }

        }
return res;
    }
}