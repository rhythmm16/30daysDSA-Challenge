class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, idx = 0;
        boolean up = true; // direction flag

        while (idx < m * n) {
            result[idx++] = mat[row][col];

            if (up) { // moving up-right
                if (col == n - 1) { // right boundary
                    row++;
                    up = false;
                } else if (row == 0) { // top boundary
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else { // moving down-left
                if (row == m - 1) { // bottom boundary
                    col++;
                    up = true;
                } else if (col == 0) { // left boundary
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
