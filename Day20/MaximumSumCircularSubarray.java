class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            // For max subarray (Kadane)
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // For min subarray (to find the wrap-around case)
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        // If all elements are negative, maxSum is the correct answer
        if (maxSum < 0) return maxSum;

        // Otherwise, either it's the normal max subarray or wrapped one
        return Math.max(maxSum, totalSum - minSum);
    }
}
