class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int afterNumber = 1;
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i-1] * nums[i - 1];
        }
    afterNumber= nums[length-1];
        for (int i = length - 2; i >= 0; i--) {
                answer[i] = afterNumber * answer[i];
                afterNumber *= nums[i];
        }
        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));
//    }
}