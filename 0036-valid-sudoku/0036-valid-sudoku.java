class Solution {
    public boolean isValidSudoku(char[][] board) {

        Boolean validCol = isValidCol(board);

        if (!validCol) return false;
        Boolean validRow = isValidRow(board);
        if (!validRow) return false;
        Boolean checkinnerSquares = checkinnerSquares(board);
        if (!checkinnerSquares) return false;

        return true;
    }


    boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private Boolean isValidCol(char[][] board) {
        for (int j = 0; j < 9; j++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (isDigit(c) && hashSet.contains(Integer.parseInt(String.valueOf(c)))) {
                    return false;
                } else if (isDigit(c)) {
                    hashSet.add(Integer.parseInt(String.valueOf(c)));
                }
            }


        }
        return true;

    }


    boolean isValidRow(char[][] board) {
        for (int j = 0; j < 9; j++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[j][i];
                if (isDigit(c) && hashSet.contains(Integer.parseInt(String.valueOf(c)))) {
                    return false;
                } else if (isDigit(c)) {
                    hashSet.add(Integer.parseInt(String.valueOf(c)));
                }
            }


        }
        return true;
    }

    boolean checkinnerSquares(char[][] board) {
        for (int boxes = 0; boxes < 9; boxes++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = (boxes / 3) * 3; i <= (2 + (boxes / 3) * 3); i++) {
                for (int j = (boxes % 3) * 3; j <= 2 + ((boxes % 3) * 3); j++) {
                    char c = board[i][j];
                    if (isDigit(c) && hashSet.contains(Integer.parseInt(String.valueOf(c)))) {
                        return false;
                    } else if (isDigit(c)) {
                        hashSet.add(Integer.parseInt(String.valueOf(c)));
                    }
                }


            }


        }

        return true;
    }


}
