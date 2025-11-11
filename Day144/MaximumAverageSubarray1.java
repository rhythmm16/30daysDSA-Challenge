class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // initial window sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        // return the maximum average
        return maxSum / k;
    }
}
