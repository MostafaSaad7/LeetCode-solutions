import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Rec> stack = new Stack<>();
        int largestArea = -1;
        for (int i = 0; i < heights.length; i++) {
            Rec rec = new Rec(heights[i], i);
            while (!stack.empty() && stack.peek().height > rec.height) {
                largestArea = Math.max(largestArea, stack.peek().height * (i - stack.peek().index));
                rec.index = stack.peek().index;
                stack.pop();
            }

            stack.push(rec);

        }

        while (!stack.empty()) {
            largestArea= Math.max(largestArea, stack.peek().height * (heights.length - stack.peek().index));
            stack.pop();
        }

        return largestArea;
    }
}

class Rec {

    public Rec(int height, int index) {
        this.height = height;
        this.index = index;
    }

    int height;
    int index;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}