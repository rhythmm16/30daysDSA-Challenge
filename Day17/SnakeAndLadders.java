class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n) return moves;

                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    int[] pos = getCoordinates(next, n);
                    int dest = board[pos[0]][pos[1]] == -1 ? next : board[pos[0]][pos[1]];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1; // Not reachable
    }

    // Converts 1D square number to 2D row and column on the board
    private int[] getCoordinates(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;
        if ((n - row) % 2 == 0) { // Reverse direction in even-numbered rows from bottom
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}
