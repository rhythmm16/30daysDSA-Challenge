import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Keep the sliding window size at most k
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            // If duplicate is found in window, return true
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
