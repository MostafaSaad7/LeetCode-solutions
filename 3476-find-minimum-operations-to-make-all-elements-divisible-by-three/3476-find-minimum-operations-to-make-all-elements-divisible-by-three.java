class Solution {
    public int minimumOperations(int[] nums) {
        int operations=0;
        for (int num: nums) {
            operations+=Math.min(num%3 , 3-(num%3));
        }

        return operations;
    }
}