import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posSpeedMat = new TreeMap<>((o1, o2) -> Integer.compare(o2,o1));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            posSpeedMat.put(position[i], speed[i]);
        }

        for (var entry : posSpeedMat.entrySet()) {
            double time = (double)(target -  entry.getKey()) / entry.getValue();
            if (!stack.isEmpty() && time <= stack.peek())
                continue;
            stack.push(time);

        }

        return stack.size();

    }
}

