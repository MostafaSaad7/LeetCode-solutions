import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> mnPq = new PriorityQueue<>();
        PriorityQueue<Integer> mxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            mnPq.add(num);
            mxPq.add(num);
            if (mnPq.size() > 3) {
                mnPq.poll();
            }

            if (mxPq.size() > 2) {
                mxPq.poll();
            }
        }

        int mx1 = mnPq.poll();
        int mx2 = mnPq.poll();
        int mx3 = mnPq.poll();

        int mn1 = mxPq.poll();
        int mn2 = mxPq.poll();

        return Math.max(mn1 * mn2 * mx3, mx1 * mx2 * mx3);

    }
}