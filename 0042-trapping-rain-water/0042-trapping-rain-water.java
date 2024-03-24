class Solution {
    public int trap(int[] height) {

        int res = 0;
        int maxHeightIndex = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxHeightIndex]) {
                maxHeightIndex = i;
            }

        }
        int leftMax = 0;
        for (int i = 0; i < maxHeightIndex; i++) {
            leftMax = Math.max(leftMax, height[i]);
            res += leftMax - height[i];
        }
        int rightMax = 0;
        for (int i = height.length-1; i > maxHeightIndex; i--) {
            rightMax = Math.max(rightMax, height[i]);
            res += rightMax - height[i];
        }



        return res;
    }
}