class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = nums[0];             // dp[i - 2]
        int prev2 = Math.max(nums[0], nums[1]); // dp[i - 1]

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
