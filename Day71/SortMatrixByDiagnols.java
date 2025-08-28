import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Process each diagonal
        for (int d = -(n - 1); d <= n - 1; d++) {
            List<Integer> diag = new ArrayList<>();

            // Collect diagonal elements
            for (int i = 0; i < n; i++) {
                int j = i - d;
                if (j >= 0 && j < n) {
                    diag.add(grid[i][j]);
                }
            }

            // Sort depending on triangle
            if (d >= 0) { 
                // bottom-left including main diagonal
                diag.sort(Collections.reverseOrder()); 
            } else { 
                // top-right
                Collections.sort(diag); 
            }

            // Put values back into grid
            int idx = 0;
            for (int i = 0; i < n; i++) {
                int j = i - d;
                if (j >= 0 && j < n) {
                    grid[i][j] = diag.get(idx++);
                }
            }
        }
        return grid;
    }
}
