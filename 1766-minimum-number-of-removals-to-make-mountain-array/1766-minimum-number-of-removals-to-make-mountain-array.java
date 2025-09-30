import java.util.Arrays;

class Solution {
    int[] lisDp;
    int[] ldsDp;

    public int minimumMountainRemovals(int[] nums) {
        lisDp = new int[nums.length];
        ldsDp = new int[nums.length];
        Arrays.fill(lisDp, -1);
        Arrays.fill(ldsDp, -1);

        int maxMountainLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = lisEndAt(i, nums);
            int y = ldsStartAt(i, nums);

            // valid peak must not be at ends and must have LIS and LDS > 1
            if (i > 0 && i < nums.length - 1 && x > 1 && y > 1) {
                maxMountainLen = Math.max(maxMountainLen, x + y - 1);
            }
        }

        return nums.length - maxMountainLen;
    }

    public int lisEndAt(int index, int[] nums) {
        if (lisDp[index] != -1) return lisDp[index];

        int seqLen = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < nums[index]) {
                seqLen = Math.max(seqLen, lisEndAt(i, nums));
            }
        }
        seqLen += 1;
        return lisDp[index] = seqLen;
    }

    public int ldsStartAt(int index, int[] nums) {
        if (ldsDp[index] != -1) return ldsDp[index];

        int seqLen = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] < nums[index]) {
                seqLen = Math.max(seqLen, ldsStartAt(i, nums));
            }
        }
        seqLen += 1;
        return ldsDp[index] = seqLen;
    }
}
