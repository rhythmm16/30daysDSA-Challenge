class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram heights
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) height[j] = 0;
                else height[j] += 1;
            }

            // Count submatrices ending at this row
            result += countFromHistogram(height);
        }

        return result;
    }

    private int countFromHistogram(int[] height) {
        int n = height.length;
        int[] sum = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[i] = sum[prev] + height[i] * (i - prev);
            } else {
                sum[i] = height[i] * (i + 1);
            }

            res += sum[i];
            stack.push(i);
        }
        return res;
    }
}
