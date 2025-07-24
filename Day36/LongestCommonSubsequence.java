class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        // Create a 2D DP array
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Fill the dp table from bottom-right to top-left
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If characters match, increment the count from previous index
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum from previous states
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the final result
        return dp[length1][length2];
    }
}
