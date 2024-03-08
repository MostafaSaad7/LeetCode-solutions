class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqArr = new int[101];
        int maxFreq = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            freqArr[nums[i]]++;
            maxFreq = Math.max(freqArr[nums[i]], maxFreq);
        }
        for (int i = 0; i < 101; i++) {
            if (freqArr[i] == maxFreq) {
                res += maxFreq;
            }
        }
        return res;
    }
}