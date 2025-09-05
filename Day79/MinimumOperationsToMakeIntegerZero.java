public class MinimumOperationsToMakeIntegerZero {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try all possible number of operations k (1 to 60)
        for (int k = 1; k <= 60; k++) {
            long target = num1 - (long)num2 * k;
            // target must be at least k (since we need k powers of 2, each at least 1)
            // and target must be representable as sum of k powers of 2 (i.e., k bits set in binary)
            if (target >= k && Long.bitCount(target) <= k) {
                return k;
            }
        }
        return -1;
    }
}