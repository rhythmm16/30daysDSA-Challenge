import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Build adjacency list: store (neighbor, direction)
        // direction = 1 means edge is going away from current node (needs change)
        // direction = 0 means edge is coming toward current node (already fine)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : connections) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], 1});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            int next = neighbor[0];
            int dir = neighbor[1];
            if (!visited[next]) {
                // If direction == 1, this edge is pointing away from 0 → needs change
                changes += dir + dfs(next, graph, visited);
            }
        }
        return changes;
    }
}
