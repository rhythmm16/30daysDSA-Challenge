import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Combine capital and profit into a list of projects
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by required capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        // Max heap for available profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        while (k-- > 0) {
            // Push all projects whose capital requirement is <= current capital into heap
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }

            // If no projects are affordable, break
            if (maxHeap.isEmpty()) break;

            // Choose the most profitable available project
            w += maxHeap.poll();
        }

        return w;
    }
}
