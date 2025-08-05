class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        // Move window rightward: start from leftmost possible position
        while (right < n && fruits[right][0] <= startPos + k) {
            sum += fruits[right][1];

            // While not possible to reach this window with k steps
            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                sum -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, sum);
            right++;
        }

        return maxFruits;
    }

    // Check if reachable: two strategies
    private boolean isReachable(int leftPos, int rightPos, int startPos, int k) {
        // Go left first, then right
        int dist1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        // Go right first, then left
        int dist2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        return Math.min(dist1, dist2) <= k;
    }
}
