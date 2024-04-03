class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Iterate through the board to start searching for the word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, 0, i, j))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        // Base case: If all characters in the word are found
        if (index == word.length()) return true;
        
        // Check boundary conditions and if the current cell is already visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index))
            return false;
        
        // Mark the current cell as visited
        visited[row][col] = true;
        
        // Explore adjacent cells
        boolean found = dfs(board, visited, word, index + 1, row + 1, col) ||
                        dfs(board, visited, word, index + 1, row - 1, col) ||
                        dfs(board, visited, word, index + 1, row, col + 1) ||
                        dfs(board, visited, word, index + 1, row, col - 1);
        
        // Reset the visited status before returning
        visited[row][col] = false;
        
        return found;
    }
}
