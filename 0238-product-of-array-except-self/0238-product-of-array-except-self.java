class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int afterNumber = 1;
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = afterNumber * answer[i];
            afterNumber *= nums[i];
        }
        return answer;
    }
    
}