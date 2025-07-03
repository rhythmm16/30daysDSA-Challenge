import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                levelSum += current.val;

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            result.add(levelSum / levelSize);
        }

        return result;
    }
}
