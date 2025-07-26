import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int maxSum = 0;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            while (seen.contains(nums[end])) {
                seen.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            seen.add(nums[end]);
            currentSum += nums[end];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
