class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost, min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, min is in the left half (including mid)
                right = mid;
            }
        }

        // After loop ends, left == right pointing to the smallest element
        return nums[left];
    }
}
