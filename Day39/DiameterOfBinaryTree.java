class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        // Update diameter if the path through this node is longer
        diameter = Math.max(diameter, left + right);

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
