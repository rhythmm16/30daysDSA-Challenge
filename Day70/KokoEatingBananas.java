class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need bigger speed
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile/k)
            if (hours > h) return false; // prune early
        }
        return hours <= h;
    }
}
