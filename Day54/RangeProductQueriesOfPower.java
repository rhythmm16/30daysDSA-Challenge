class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int mod = 1_000_000_007;

        // Extract powers of two from n
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) powers.add(1 << i);
            n >>= 1;
        }

        // Prefix products
        long[] prefix = new long[powers.size() + 1];
        prefix[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % mod;
        }

        // Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = (int)((prefix[r + 1] * powMod(prefix[l], mod - 2, mod)) % mod);
        }

        return ans;
    }

    // Fast power
    private long powMod(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
