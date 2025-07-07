class Solution {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];        // columns
        boolean[] diag1 = new boolean[2 * n];    // top-left to bottom-right diagonals
        boolean[] diag2 = new boolean[2 * n];    // top-right to bottom-left diagonals

        return solve(0, n, cols, diag1, diag2);
    }

    private int solve(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) return 1;

        int count = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // shifting index to avoid negative
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            cols[col] = diag1[d1] = diag2[d2] = true;
            count += solve(row + 1, n, cols, diag1, diag2);
            cols[col] = diag1[d1] = diag2[d2] = false; // backtrack
        }
        return count;
    }
}
