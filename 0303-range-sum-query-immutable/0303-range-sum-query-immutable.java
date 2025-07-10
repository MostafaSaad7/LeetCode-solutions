class NumArray {
    int[] prefixArray;

    public NumArray(int[] nums) {
        prefixArray = new int[nums.length];
        prefixArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixArray[right];
        }
        return prefixArray[right] - prefixArray[left - 1];
    }
}
