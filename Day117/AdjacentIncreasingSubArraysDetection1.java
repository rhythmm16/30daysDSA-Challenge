class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] inc = new boolean[n];

        // Mark all starting indices of strictly increasing subarrays of length k
        for (int i = 0; i + k <= n; i++) {
            boolean ok = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    ok = false;
                    break;
                }
            }
            inc[i] = ok;
        }

        // Check for adjacent increasing subarrays
        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i] && inc[i + k]) return true;
        }

        return false;
    }
}
