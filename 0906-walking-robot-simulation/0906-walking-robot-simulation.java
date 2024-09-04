import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;
        Set<String> obstacleSet = new HashSet<>();

        // Add obstacles to the set
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int result = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                // Turn right
                currentDirection = (currentDirection + 1) % 4;
            } else if (cmd == -2) {
                // Turn left
                currentDirection = (currentDirection + 3) % 4;
            } else {
                // Move forward
                int dx = directions[currentDirection][0];
                int dy = directions[currentDirection][1];

                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dx;
                    int nextY = y + dy;

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        // Stop if an obstacle is encountered
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    result = Math.max(result, x * x + y * y);
                }
            }
        }

        return result;
    }
}
