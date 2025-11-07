class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; ++i) pref[i + 1] = pref[i] + stations[i];

        // power[i] = sum of stations in [i-r, i+r]
        long[] power = new long[n];
        for (int i = 0; i < n; ++i) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = pref[R + 1] - pref[L];
        }

        long left = 0;
        long right = pref[n] + k; // max possible power for any city
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (canReach(mid, power, r, k, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(long target, long[] power, int r, long k, int n) {
        long[] diff = new long[n]; // difference array for added power
        long add = 0;   // current cumulative added power affecting city i
        long used = 0;  // total stations used

        for (int i = 0; i < n; ++i) {
            // remove effects that no longer apply
            if (i - r - 1 >= 0) add -= diff[i - r - 1];

            long curr = power[i] + add;
            if (curr < target) {
                long need = target - curr;
                used += need;
                if (used > k) return false;

                int pos = Math.min(n - 1, i + r); // place added stations as right as possible
                diff[pos] += need;  // schedule addition (its effect starts now)
                add += need;        // immediate increase for current city
            }
        }
        return true;
    }
}
