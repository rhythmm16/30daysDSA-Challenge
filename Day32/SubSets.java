import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        generateSubsets(0, nums, currentSubset, result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in the subset
            currentSubset.add(nums[i]);

            // Recurse to the next element
            generateSubsets(i + 1, nums, currentSubset, result);

            // Backtrack: remove last added element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
