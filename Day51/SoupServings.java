class Solution {
    private double[][] memo;

    public double soupServings(int n) {
        // Optimization: for large n, probability approaches 1
        if (n > 4800) return 1.0;

        int m = (n + 24) / 25; // scale down to 25 mL units
        memo = new double[m + 1][m + 1];
        return dfs(m, m);
    }

    private double dfs(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5; // both empty at the same time
        if (a <= 0) return 1.0;           // A is empty first
        if (b <= 0) return 0.0;           // B is empty first

        // Memoization check
        if (memo[a][b] > 0) return memo[a][b];

        // Recurrence: 4 possible serving operations, each with probability 0.25
        memo[a][b] = 0.25 * (
            dfs(a - 4, b) +
            dfs(a - 3, b - 1) +
            dfs(a - 2, b - 2) +
            dfs(a - 1, b - 3)
        );
        return memo[a][b];
    }
}
