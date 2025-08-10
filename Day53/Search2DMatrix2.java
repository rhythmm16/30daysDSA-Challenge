class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // number of rows
        int n = matrix[0].length;    // number of columns
        
        int row = 0;     // start from top row
        int col = n - 1; // start from rightmost column
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // found target
            } else if (matrix[row][col] > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        
        return false; // not found
    }
}
