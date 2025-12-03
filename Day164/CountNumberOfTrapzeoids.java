import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count how many points lie on each y-level
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        List<Long> combos = new ArrayList<>();

        // For each y with >= 2 points, compute C(cnt,2)
        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long c = (long) cnt * (cnt - 1) / 2;  // C(cnt,2)
                combos.add(c % MOD);
            }
        }

        // Now sum over all i < j: combos[i] * combos[j]
        long ans = 0;
        long prefix = 0;

        for (long c : combos) {
            ans = (ans + (prefix * c) % MOD) % MOD;
            prefix = (prefix + c) % MOD;
        }

        return (int) ans;
    }
}
