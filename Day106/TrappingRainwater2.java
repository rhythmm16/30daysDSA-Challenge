import java.util.*;

class Solution {
    private static class Cell {
        int row, col, height;
        Cell(int r, int c, int h) {
            row = r; col = c; height = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // No trapping possible
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        // Step 1: Add all boundary cells to heap
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        // Step 2: BFS with heap
        int totalWater = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] d : dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];

                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
                visited[r][c] = true;

                // If neighbor lower than current boundary, trap water
                totalWater += Math.max(0, cell.height - heightMap[r][c]);

                // Update effective height (water may raise level)
                pq.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
            }
        }
        return totalWater;
    }
}
