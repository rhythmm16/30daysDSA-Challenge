class Solution {
    public double myPow(double x, int n) {
        // Convert n to long to handle edge case where n = Integer.MIN_VALUE
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;
        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }

        return result;
    }
}
