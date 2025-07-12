class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes, also numbers ending with 0 (but not 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // For even-length numbers, x == reversedHalf
        // For odd-length numbers, x == reversedHalf / 10 (middle digit doesn't matter)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
