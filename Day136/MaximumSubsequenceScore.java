import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        
        // Pair nums2 and nums1
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        
        // Sort by nums2 descending (we’ll treat each nums2[i] as potential minimum)
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            // Add current nums1 to heap and sum
            sum += pairs[i][1];
            minHeap.add(pairs[i][1]);
            
            // Keep only top k elements in heap
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            // If we have exactly k elements, compute possible score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * pairs[i][0]);
            }
        }
        
        return maxScore;
    }
}
