import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

class MinStack {
    Stack<Map.Entry<Integer, Integer>> stack;
    // Entry key is the inserted value into the stack, Entry value is the min value in the stack at this time


    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int minValue = Math.min(stack.empty() ? val : stack.peek().getValue(), val);
        stack.push(new AbstractMap.SimpleImmutableEntry<>(val,minValue));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }
}