class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get the max gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);  // discard negative paths
        int rightGain = Math.max(maxGain(node.right), 0);

        // Price of the path that goes through the current node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global maximum if needed
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain the current node can contribute to its parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
