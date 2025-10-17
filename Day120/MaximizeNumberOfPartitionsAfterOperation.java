import java.util.*;

class Solution {
    String s;
    int k, n;
    Map<String, Integer> memo = new HashMap<>();

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        return dfs(0, 0, false);
    }

    private int dfs(int i, int mask, boolean used) {
        if (i == n) return 1;

        String key = i + "," + mask + "," + used;
        if (memo.containsKey(key)) return memo.get(key);

        int ch = s.charAt(i) - 'a';
        int best = 0;

        // Option 1: don’t change this character
        int newMask = mask | (1 << ch);
        int cnt = Integer.bitCount(newMask);
        if (cnt > k) {
            best = Math.max(best, 1 + dfs(i + 1, 1 << ch, used));
        } else {
            best = Math.max(best, dfs(i + 1, newMask, used));
        }

        // Option 2: change this character (only once)
        if (!used) {
            for (int c = 0; c < 26; c++) {
                int newMask2 = mask | (1 << c);
                int cnt2 = Integer.bitCount(newMask2);
                if (cnt2 > k) {
                    best = Math.max(best, 1 + dfs(i + 1, 1 << c, true));
                } else {
                    best = Math.max(best, dfs(i + 1, newMask2, true));
                }
            }
        }

        memo.put(key, best);
        return best;
    }
}
+