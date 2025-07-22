import java.util.HashSet;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0, maxSum = 0, currentSum = 0;

        while (right < nums.length) {
            // If element is not in the set, expand the window
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                currentSum += nums[right];
                maxSum = Math.max(maxSum, currentSum);
                right++;
            } else {
                // Shrink the window until duplicate is removed
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
