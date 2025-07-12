class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from last digit to first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Just add 1 if it's < 9 and return
                return digits;
            }
            digits[i] = 0; // Set to 0 and carry over to next digit
        }

        // If all digits were 9, we need one extra digit at the start
        int[] result = new int[n + 1];
        result[0] = 1; // e.g., 999 + 1 = 1000
        return result;
    }
}
