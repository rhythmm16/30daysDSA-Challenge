class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) return 0;

        currentNumber = currentNumber * 10 + node.val;

        // If it's a leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Recurse left and right, summing the path values
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        return leftSum + rightSum;
    }
}
