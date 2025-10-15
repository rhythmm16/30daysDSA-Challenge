class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        int[] incRev = new int[n];

        // increasing length ending at i
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        // increasing length starting at i
        incRev[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) incRev[i] = incRev[i + 1] + 1;
            else incRev[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.min(inc[i], incRev[i + 1]));
        }

        return ans;
    }
}
