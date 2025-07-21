import java.util.HashMap;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // Map to store prefix sums and their frequencies
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: empty path has sum 0
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // Add current node's value to running sum
        currentSum += node.val;

        // Count paths ending at current node that sum to target
        int pathsToCurrent = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Add current sum to map
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recurse into left and right subtrees
        int result = pathsToCurrent
            + dfs(node.left, currentSum, targetSum, prefixSumCount)
            + dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack: remove current sum before returning to parent
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
    }
}
