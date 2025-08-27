import java.util.*;

class Solution {
    
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxLength = 0;
        
        // Define diagonal directions: top-right, bottom-right, bottom-left, top-left
        int[][] directions = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        
        // For each starting point with value 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Try each direction
                    for (int d = 0; d < 4; d++) {
                        int[] dir = directions[d];
                        
                        // First explore without any turn
                        int straightPath = exploreDirection(grid, i, j, dir, true);
                        maxLength = Math.max(maxLength, straightPath);
                        
                        // Try making a turn at each point along the path
                        int x = i, y = j;
                        int sequence = 1; // Start with 1 (next expected is 2)
                        
                        for (int step = 0; step < straightPath - 1; step++) {
                            x += dir[0];
                            y += dir[1];
                            
                            // Update next expected value in sequence
                            sequence = grid[x][y];
                            int nextExpected = (sequence == 2) ? 0 : 2;
                            
                            // Try making a clockwise turn here
                            int nextDir = (d + 1) % 4;
                            int lengthAfterTurn = exploreDirectionAfterTurn(grid, x, y, directions[nextDir], nextExpected);
                            
                            // Total length = steps to this point + length after turn
                            maxLength = Math.max(maxLength, step + 1 + 1 + lengthAfterTurn); // +1 for start, +1 for current
                        }
                    }
                }
            }
        }
        
        return maxLength;
    }
    
    // Explores diagonal in given direction from starting point
    private int exploreDirection(int[][] grid, int i, int j, int[] dir, boolean isStart) {
        int n = grid.length, m = grid[0].length;
        int length = isStart ? 1 : 0; // Count starting point only if it's the beginning
        
        int x = i, y = j;
        int expected = isStart ? 2 : grid[i][j]; // First expected is 2 if starting with 1
        
        while (true) {
            x += dir[0];
            y += dir[1];
            
            if (x < 0 || x >= n || y < 0 || y >= m) break;
            
            // Check if next value follows sequence
            if (grid[x][y] != expected) break;
            
            length++;
            expected = (expected == 2) ? 0 : 2; // Toggle between 2 and 0
        }
        
        return length;
    }
    
    // Explores after making a turn
    private int exploreDirectionAfterTurn(int[][] grid, int i, int j, int[] dir, int expected) {
        int n = grid.length, m = grid[0].length;
        int length = 0;
        int x = i, y = j;
        
        while (true) {
            x += dir[0];
            y += dir[1];
            
            if (x < 0 || x >= n || y < 0 || y >= m) break;
            
            if (grid[x][y] != expected) break;
            
            length++;
            expected = (expected == 2) ? 0 : 2; // Toggle between 2 and 0
        }
        
        return length;
    }
}