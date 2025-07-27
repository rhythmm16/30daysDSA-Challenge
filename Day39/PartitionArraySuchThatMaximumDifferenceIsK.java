import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);  // Sort to group similar elements
        int count = 1;      // At least one group is needed
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                count++;
                start = nums[i]; // Start a new group
            }
        }

        return count;
    }
}
