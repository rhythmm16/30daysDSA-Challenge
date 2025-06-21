class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;  // Farthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;  // Can't reach this index
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
