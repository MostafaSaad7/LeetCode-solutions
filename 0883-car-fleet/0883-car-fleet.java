import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }

        // Sort cars based on position in descending order
        cars.sort((a, b) -> Integer.compare(b[0], a[0]));

        // Stack to keep track of fleets
        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue; // This car joins the current fleet
            }
            stack.push(time); // This car forms a new fleet
        }

        return stack.size();
    }
}
