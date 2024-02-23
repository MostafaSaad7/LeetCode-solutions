class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int beforeNumber = 1;
        int afterNumber = 1;
        int length = nums.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                answer[i] = beforeNumber;
            } else {
                answer[i] = beforeNumber * nums[i - 1];
                beforeNumber *= nums[i - 1];
            }

        }


        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                answer[i] = afterNumber * answer[i];
                afterNumber = nums[i];
            } else {
                answer[i] = afterNumber * answer[i];
                afterNumber *= nums[i];
            }

        }
        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));
//    }
}