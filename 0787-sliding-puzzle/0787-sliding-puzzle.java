/**
 * Sliding Puzzle Solver using BFS
 * 
 * Problem: Given a 2x3 sliding puzzle, find minimum moves to reach goal state "123450"
 * 
 * Time Complexity: O(6!) = O(720) - at most 6! possible states in 2x3 grid
 * Space Complexity: O(6!) = O(720) - for visited set and queue storage
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        // Goal state: [[1,2,3], [4,5,0]]
        String target = "123450";
        
        // Direction map: for each position, which positions can the empty space move to
        // Position mapping: [0,1,2]
        //                  [3,4,5]
        int[][] directions = {
            {1, 3},        // position 0 can move to positions 1, 3
            {0, 2, 4},     // position 1 can move to positions 0, 2, 4  
            {1, 5},        // position 2 can move to positions 1, 5
            {0, 4},        // position 3 can move to positions 0, 4
            {1, 3, 5},     // position 4 can move to positions 1, 3, 5
            {2, 4}         // position 5 can move to positions 2, 4
        };
        
        // Convert 2D board to string representation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);  // Much cleaner than C++ version!
            }
        }
        String startState = sb.toString();
        
        // Already at goal state
        if (target.equals(startState)) {
            return 0;
        }
        
        // BFS setup
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(startState);
        visited.add(startState);
        
        int moves = 0;
        
        // BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            moves++;
            
            // Process all states at current level
            for (int i = 0; i < levelSize; i++) {
                String currentState = queue.poll();
                
                // Find position of empty space (0)
                int emptyPos = currentState.indexOf('0');
                
                // Try all possible moves for empty space
                for (int nextPos : directions[emptyPos]) {
                    // Create new state by swapping empty space with adjacent number
                    String newState = swap(currentState, emptyPos, nextPos);
                    
                    // Found solution!
                    if (target.equals(newState)) {
                        return moves;
                    }
                    
                    // Add to queue if not visited
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }
        }
        
        // No solution exists
        return -1;
    }
    
    /**
     * Helper method to swap two characters in a string
     * Java strings are immutable, so we need to convert to char array
     */
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
