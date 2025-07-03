class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // Left subtree is full
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // Right subtree is full
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    // Helper to calculate depth (leftmost path only)
    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}
