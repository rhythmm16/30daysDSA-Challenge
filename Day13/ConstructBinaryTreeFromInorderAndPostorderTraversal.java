class Solution {
    private Map<Integer, Integer> inorderMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postIndex = n - 1;
        inorderMap = new HashMap<>();

        // Map value to index for quick lookup
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, n - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        // Build right subtree before left subtree (reverse of preorder)
        root.right = buildTreeHelper(postorder, inIndex + 1, inRight);
        root.left = buildTreeHelper(postorder, inLeft, inIndex - 1);

        return root;
    }
}
