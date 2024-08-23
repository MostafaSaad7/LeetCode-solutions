/**
 * This method calculates the largest rectangle area in a histogram.
 * 
 * Explanation:
 * - We iterate through the heights array, using a stack to track the indices and heights of bars.
 * - The idea is to maintain a stack of heights that are in increasing order.
 * - When we encounter a bar that is shorter than the bar at the top of the stack, we know that the top bar
 *   will not extend any further, so we pop it from the stack and calculate the area of the rectangle that
 *   it forms, using it as the smallest height.
 * - We calculate the area as the height of the popped bar multiplied by the width, which is the difference
 *   between the current index and the index of the bar that was below the popped bar in the stack.
 * - We continue this process until all bars have been processed, and then handle any remaining bars in the stack.
 * 
 * Time Complexity:
 * - O(n): Each bar is pushed and popped from the stack at most once, so the overall time complexity is linear.
 * 
 * Space Complexity:
 * - O(n): The space complexity is determined by the stack, which in the worst case can store all the bars.
 */



class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        int start;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int curHt =heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > curHt){
                Pair<Integer,Integer> pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new Pair(start,curHt));
        }

        while(!stack.isEmpty()){
            Pair<Integer,Integer> pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area, h * (n - index));
        }
        return area;
    }

}
