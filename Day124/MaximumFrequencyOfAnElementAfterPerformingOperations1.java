import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, maxFreq = 0;

        for (int right = 0; right < n; right++) {
            // shrink window if not enough overlap
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }

            // window length = elements that can be made same
            int window = right - left + 1;

            // we can modify at most numOperations indices
            maxFreq = Math.max(maxFreq, Math.min(window, numOperations + 1));
        }

        return maxFreq;
    }
}
