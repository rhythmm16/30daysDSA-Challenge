class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // To avoid overflow, use long for multiplication
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;       // mid is a possible answer
                left = mid + 1;  // try to find a larger one
            } else {
                right = mid - 1; // try smaller
            }
        }

        return ans;
    }
}
