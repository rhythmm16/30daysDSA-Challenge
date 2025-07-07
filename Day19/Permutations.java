class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // add a deep copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used elements

            current.add(nums[i]);      // choose
            used[i] = true;            // mark as used
            backtrack(nums, used, current, result); // explore
            used[i] = false;           // unmark
            current.remove(current.size() - 1); // unchoose
        }
    }
}
