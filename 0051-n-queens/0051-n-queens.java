import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // Array to store the column position of queens, index represents the row
        backtrack(0, queens, n, result);
        return result;
    }

    private void backtrack(int row, int[] queens, int n, List<List<String>> result) {
        if (row == n) {
            result.add(createBoard(queens, n)); // If all rows are filled, add the solution to the result
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(row, col, queens)) {
                queens[row] = col; // Place the queen
                backtrack(row + 1, queens, n, result); // Move to the next row
                // Backtrack: After exploring the row, the queen is implicitly "removed" by overwriting in the next loop
            }
        }
    }

    private boolean canPlaceQueen(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            int prevCol = queens[i];
            // Check if the current column or any diagonals are occupied by a previously placed queen
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private List<String> createBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            row[queens[i]] = 'Q'; // Place the queen at the correct position in the row
            board.add(new String(row));
        }
        return board;
    }


}
