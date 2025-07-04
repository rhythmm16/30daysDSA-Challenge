class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark border-connected 'O's with '#'
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Step 2: Flip remaining 'O's to 'X', and '#' back to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';  // surrounded region
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';  // safe region
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#'; // Temporarily mark as visited

        // Explore 4 directions
        dfs(board, r - 1, c); // up
        dfs(board, r + 1, c); // down
        dfs(board, r, c - 1); // left
        dfs(board, r, c + 1); // right
    }
}
