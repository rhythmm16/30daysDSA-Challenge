class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: if k == 0, or n is large enough to always succeed
        if (k == 0 || n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0;
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // Still possible to draw further
                windowSum += dp[i];
            } else {
                // At or beyond k → stop here
                result += dp[i];
            }

            // Maintain sliding window of last maxPts values
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        return result;
    }
}
