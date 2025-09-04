import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        // Store rows as string representation
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        // Compare columns with stored rows
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String key = Arrays.toString(col);
            count += rowMap.getOrDefault(key, 0);
        }

        return count;
    }
}
