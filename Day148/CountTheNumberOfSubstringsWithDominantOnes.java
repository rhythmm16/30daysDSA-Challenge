class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int[] pref1 = new int[n + 1];
        int[] pref0 = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref1[i + 1] = pref1[i] + (s.charAt(i) == '1' ? 1 : 0);
            pref0[i + 1] = pref0[i] + (s.charAt(i) == '0' ? 1 : 0);
        }

        // max zeros we need to consider
        int LIMIT = 200;

        for (int r = 0; r < n; r++) {
            // we will move l backwards and count zeros
            int zeroCount = 0;

            // only check up to 200 zeros backward
            for (int l = r; l >= 0 && zeroCount <= LIMIT; l--) {
                if (s.charAt(l) == '0') zeroCount++;

                int ones = pref1[r + 1] - pref1[l];
                if (ones >= zeroCount * zeroCount) {
                    res++;
                }
            }
        }

        return res;
    }
}
