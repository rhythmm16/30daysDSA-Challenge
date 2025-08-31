class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {  // find empty cell
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // choose
                            if (backtrack(board)) return true; // explore
                            board[i][j] = '.'; // unchoose (backtrack)
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // all cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false; // check row
            if (board[k][col] == c) return false; // check col
            if (board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) return false; // check 3x3 box
        }
        return true;
    }
}
