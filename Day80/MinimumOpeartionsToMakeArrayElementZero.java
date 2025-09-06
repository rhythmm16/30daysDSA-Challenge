class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long totalSteps = prefix(q[1]) - prefix(q[0] - 1);
            ans += (totalSteps + 1) / 2;
        }
        return ans;
    }

    private long prefix(long n) {
        if (n <= 0) return 0;
        long res = 0;
        long start = 1;
        int step = 1;
        while (start <= n) {
            long end = Math.min(n, start * 4 - 1);
            res += (end - start + 1) * (long) step;
            start *= 4;
            step++;
        }
        return res;
    }
}
