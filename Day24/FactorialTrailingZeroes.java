class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        // Each 5 contributes to a trailing zero (via 2 * 5 = 10)
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
