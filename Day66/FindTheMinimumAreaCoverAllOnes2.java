class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // --- 1. Horizontal cuts ---
        for (int r1 = 0; r1 < n-2; r1++) {
            for (int r2 = r1+1; r2 < n-1; r2++) {
                int area1 = boundingBoxArea(grid, 0, 0, r1, m-1);
                int area2 = boundingBoxArea(grid, r1+1, 0, r2, m-1);
                int area3 = boundingBoxArea(grid, r2+1, 0, n-1, m-1);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        // --- 2. Vertical cuts ---
        for (int c1 = 0; c1 < m-2; c1++) {
            for (int c2 = c1+1; c2 < m-1; c2++) {
                int area1 = boundingBoxArea(grid, 0, 0, n-1, c1);
                int area2 = boundingBoxArea(grid, 0, c1+1, n-1, c2);
                int area3 = boundingBoxArea(grid, 0, c2+1, n-1, m-1);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        // --- 3. Mixed partitions (L shapes) ---
        for (int r = 0; r < n-1; r++) {
            for (int c = 0; c < m-1; c++) {
                // top + bottom-left + bottom-right
                int area1 = boundingBoxArea(grid, 0, 0, r, m-1);
                int area2 = boundingBoxArea(grid, r+1, 0, n-1, c);
                int area3 = boundingBoxArea(grid, r+1, c+1, n-1, m-1);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);

                // left + top-right + bottom-right
                area1 = boundingBoxArea(grid, 0, 0, n-1, c);
                area2 = boundingBoxArea(grid, 0, c+1, r, m-1);
                area3 = boundingBoxArea(grid, r+1, c+1, n-1, m-1);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);

                // bottom + top-left + top-right
                area1 = boundingBoxArea(grid, r+1, 0, n-1, m-1);
                area2 = boundingBoxArea(grid, 0, 0, r, c);
                area3 = boundingBoxArea(grid, 0, c+1, r, m-1);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);

                // right + top-left + bottom-left
                area1 = boundingBoxArea(grid, 0, c+1, n-1, m-1);
                area2 = boundingBoxArea(grid, 0, 0, r, c);
                area3 = boundingBoxArea(grid, r+1, 0, n-1, c);
                if (area1 > 0 && area2 > 0 && area3 > 0)
                    ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        return ans;
    }

    // Computes bounding box of 1s inside subgrid (r1..r2, c1..c2)
    private int boundingBoxArea(int[][] grid, int r1, int c1, int r2, int c2) {
        int minR = Integer.MAX_VALUE, maxR = -1, minC = Integer.MAX_VALUE, maxC = -1;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        if (maxR == -1) return 0; // no 1 inside
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
