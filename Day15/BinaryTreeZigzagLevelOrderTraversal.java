import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();

                if (leftToRight) {
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);  // Reverses order
                }

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            result.add(level);
            leftToRight = !leftToRight;  // Flip direction
        }

        return result;
    }
}
