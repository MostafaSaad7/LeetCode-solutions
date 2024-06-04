import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> minStack = new Stack<>();
        int res[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!minStack.empty() && temperatures[i] > temperatures[minStack.peek()]) {
                int temp= minStack.pop();
                res[temp] = i - temp;
            }
            minStack.push(i);
        }


        return res;
    }
}

/*
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 *
 * */