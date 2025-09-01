class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        long[] p = new long[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * p[i - 3]) % MOD;
            p[i] = (p[i - 1] + dp[i - 1]) % MOD;
        }
        return (int) dp[n];
    }
}
