class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Update the grid in-place to save space
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0]; // First column
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1]; // First row
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]); // Take the min path
            }
        }

        return grid[m - 1][n - 1]; // Bottom-right corner has the answer
    }
}
