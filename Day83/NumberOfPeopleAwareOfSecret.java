class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];  // dp[i] = number of people who learn the secret on day i
        dp[1] = 1;
        long share = 0;

        for (int day = 2; day <= n; day++) {
            // add new sharers (those who reach delay days ago)
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
            // remove people who forget today (those who started forget days ago)
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = share;
        }

        // sum up people who still remember at day n
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}
