import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> visit = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            visit.add(num);
        }
        for (int num : nums2) {
            if (visit.contains(num)) {
                result.add(num);
                visit.remove(num);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;

    }
}
