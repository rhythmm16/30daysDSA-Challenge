class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            // Skip if nums[i] is same as previous (part of same plateau)
            if (nums[i] == nums[i - 1]) continue;

            int left = i - 1;
            // Move left pointer to closest non-equal value
            while (left >= 0 && nums[left] == nums[i]) left--;

            int right = i + 1;
            // Move right pointer to closest non-equal value
            while (right < nums.length && nums[right] == nums[i]) right++;

            if (left >= 0 && right < nums.length) {
                if ((nums[i] > nums[left] && nums[i] > nums[right]) ||
                    (nums[i] < nums[left] && nums[i] < nums[right])) {
                    count++;
                }
            }
        }
        return count;
    }
}
