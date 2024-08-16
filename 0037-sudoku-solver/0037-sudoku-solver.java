import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][][] box = new int[3][3][9];
    List<Integer> empty_r = new ArrayList<>();
    List<Integer> empty_c = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // Mark initial reserved values
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    set(board[r][c] - '1', r, c, 1);
                } else {
                    empty_r.add(r);
                    empty_c.add(c);
                }
            }
        }

        // Start backtracking
        assert backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int idx) {
        if (idx >= empty_r.size()) {
            return true;
        }

        int r = empty_r.get(idx);
        int c = empty_c.get(idx);

        for (int d = 0; d < 9; d++) {
            if (canPlace(d, r, c)) {
                set(d, r, c, 1);
                board[r][c] = (char) (d + '1');

                if (backtrack(board, idx + 1)) {
                    return true;
                }

                // Backtrack
                set(d, r, c, 0);
                board[r][c] = '.';
            }
        }
        return false;
    }

    private boolean canPlace(int d, int r, int c) {
        return row[r][d] == 0 && col[c][d] == 0 && box[r / 3][c / 3][d] == 0;
    }

    private void set(int d, int r, int c, int value) {
        row[r][d] = value;
        col[c][d] = value;
        box[r / 3][c / 3][d] = value;
    }
}
