import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMost = null;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                rightMost = current;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // Add the last node of each level
            if (rightMost != null) {
                result.add(rightMost.val);
            }
        }

        return result;
    }
}
