class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D DP array
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all characters
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all characters

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // choose min among insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(dp[i - 1][j], // delete
                                 dp[i][j - 1]) // insert
                    );
                }
            }
        }

        return dp[m][n];
    }
}
