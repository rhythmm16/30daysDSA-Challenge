import java.util.*;

class Solution {
    int[] xorSum;
    List<Integer>[] graph;
    int totalXor = 0;
    List<int[]> edgesList = new ArrayList<>();
    int[] inTime, outTime;
    int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        xorSum = new int[n];
        graph = new ArrayList[n];
        inTime = new int[n];
        outTime = new int[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0, -1, nums);  // Compute xorSum and in/out times
        totalXor = xorSum[0];

        // Build list of edges (child, parent)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (inTime[u] > inTime[v]) edgesList.add(new int[]{u, v});
            else edgesList.add(new int[]{v, u});
        }

        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < edgesList.size(); i++) {
            for (int j = i + 1; j < edgesList.size(); j++) {
                int[] a = edgesList.get(i);
                int[] b = edgesList.get(j);

                int aNode = a[0], bNode = b[0];

                if (isAncestor(aNode, bNode)) {
                    int x = xorSum[bNode];
                    int y = xorSum[aNode] ^ xorSum[bNode];
                    int z = totalXor ^ xorSum[aNode];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                } else if (isAncestor(bNode, aNode)) {
                    int x = xorSum[aNode];
                    int y = xorSum[bNode] ^ xorSum[aNode];
                    int z = totalXor ^ xorSum[bNode];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                } else {
                    int x = xorSum[aNode];
                    int y = xorSum[bNode];
                    int z = totalXor ^ xorSum[aNode] ^ xorSum[bNode];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                }
            }
        }

        return minScore;
    }

    private int dfs(int node, int parent, int[] nums) {
        xorSum[node] = nums[node];
        inTime[node] = time++;
        for (int nei : graph[node]) {
            if (nei != parent) {
                xorSum[node] ^= dfs(nei, node, nums);
            }
        }
        outTime[node] = time++;
        return xorSum[node];
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}
