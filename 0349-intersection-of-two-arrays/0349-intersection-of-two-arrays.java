
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create a HashSet from nums1
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // Find intersection with nums2
        ArrayList<Integer> resList = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resList.add(num);
                set.remove(num); // To handle duplicates
            }
        }

        // Convert ArrayList to array
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }
}
