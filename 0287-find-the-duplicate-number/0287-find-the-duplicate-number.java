class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // First phase: finding the intersection point in the cycle
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        // Second phase: finding the entrance to the cycle
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
