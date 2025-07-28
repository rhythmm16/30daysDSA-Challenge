class Solution {
    int max = 0, count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // First compute max possible OR value
        for (int num : nums) {
            max |= num;
        }

        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currOr) {
        if (index == nums.length) {
            if (currOr == max) {
                count++;
            }
            return;
        }

        // Choose current element
        dfs(nums, index + 1, currOr | nums[index]);

        // Don't choose current element
        dfs(nums, index + 1, currOr);
    }
}
