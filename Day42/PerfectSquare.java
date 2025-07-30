class Solution {
    public int numSquares(int n) {
        // dp[i] will store the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0; // Base case

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            // Try all square numbers ≤ i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }
}
