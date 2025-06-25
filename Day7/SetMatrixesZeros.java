class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean firstRowZero = false, firstColZero = false;

        // Step 1: Check if first row or first column has any zeros
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) firstColZero = true;

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) firstRowZero = true;

        // Step 2: Use first row and column as markers for zero rows/cols
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark column
                }
            }
        }

        // Step 3: Set cells to 0 based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Step 4: Zero out first row and column if needed
        if (firstRowZero)
            for (int j = 0; j < n; j++) matrix[0][j] = 0;

        if (firstColZero)
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}
