import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int ans[] = new int[nums.length];
        Arrays.fill(ans,-1);

        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {

            while (!minStack.empty() && nums[i % nums.length] > nums[minStack.peek()]) {
                ans[minStack.peek()] = nums[i % nums.length];
                minStack.pop();
            }

            minStack.push(i % nums.length);
        }
        return ans;
    }
}

/*
*Input: nums = [1,2,1]
Output: [2,-1,2]
*
* */