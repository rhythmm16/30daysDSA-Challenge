class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2; // Start from the 3rd position

        for (int i = 2; i < nums.length; i++) {
            // Only copy nums[i] if it's not equal to the element two spots before
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
