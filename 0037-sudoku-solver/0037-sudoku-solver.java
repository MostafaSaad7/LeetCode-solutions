class Solution {
    int[][] rows = new int[9][9];
    int[][] cols = new int[9][9];
    int[][][] boxes = new int[3][3][9];

    public void solveSudoku(char[][] board) {
        // Initialize rows, cols, and boxes based on the input board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = 1;
                    cols[j][num] = 1;
                    boxes[i / 3][j / 3][num] = 1;
                }
            }
        }
        // Start the backtracking process
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int i) {
        if (i >= 81) // If we have filled all cells
            return true;

        int row = i / 9;
        int col = i % 9;

        if (board[row][col] != '.')
            return backtrack(board, i + 1);

        int boxRow = row / 3;
        int boxCol = col / 3;

        for (int num = 0; num < 9; num++) {
            if (couldPlace(row, col, boxRow, boxCol, num)) {
                board[row][col] = (char) (num + '1');
                rows[row][num] = 1;
                cols[col][num] = 1;
                boxes[boxRow][boxCol][num] = 1;

                if (backtrack(board, i + 1))
                    return true;

                // Undo the move (backtrack)
                board[row][col] = '.';
                rows[row][num] = 0;
                cols[col][num] = 0;
                boxes[boxRow][boxCol][num] = 0;
            }
        }
        return false;
    }

    private boolean couldPlace(int row, int col, int boxRow, int boxCol, int num) {
        return rows[row][num] != 1 && cols[col][num] != 1 && boxes[boxRow][boxCol][num] != 1;
    }
}
