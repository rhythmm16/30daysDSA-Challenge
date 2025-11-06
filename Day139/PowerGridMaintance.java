import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] adj = new ArrayList[c + 1];
        for (int i = 1; i <= c; i++) adj[i] = new ArrayList<>();
        for (int[] e : connections) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int n = queries.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -2); // mark all initially unanswered

        DSU dsu = new DSU(c);
        boolean[] online = new boolean[c + 1];

        // process backward
        for (int i = n - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 1) { // maintenance query
                if (online[x]) {
                    ans[i] = x;
                } else {
                    int root = dsu.find(x);
                    int minOnline = dsu.min[root];
                    ans[i] = (minOnline == Integer.MAX_VALUE ? -1 : minOnline);
                }
            } else { // type == 2, bring station back online
                online[x] = true;
                dsu.min[x] = x;
                for (int nei : adj[x]) {
                    if (online[nei]) {
                        dsu.union(x, nei);
                    }
                }
            }
        }

        // collect results in forward order
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (queries[i][0] == 1) res.add(ans[i]);
        }

        int[] finalAns = new int[res.size()];
        for (int i = 0; i < res.size(); i++) finalAns[i] = res.get(i);
        return finalAns;
    }

    // Disjoint Set Union with "min online node" tracking
    static class DSU {
        int[] parent, rank, min;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            min = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                min[i] = Integer.MAX_VALUE; // no online nodes yet
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
                min[pb] = Math.min(min[pb], min[pa]);
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                min[pa] = Math.min(min[pa], min[pb]);
            } else {
                parent[pb] = pa;
                rank[pa]++;
                min[pa] = Math.min(min[pa], min[pb]);
            }
        }
    }
}
