class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Check if left part is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies within left part
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // move to left half
                } else {
                    left = mid + 1;   // move to right half
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // move to right half
                } else {
                    right = mid - 1;  // move to left half
                }
            }
        }

        return -1; // not found
    }
}
