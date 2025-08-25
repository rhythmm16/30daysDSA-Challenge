class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If str1 + str2 != str2 + str1, then no common divisor string exists
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Find gcd of lengths
        int gcdLen = gcd(str1.length(), str2.length());
        
        // Return substring of str1 with length gcdLen
        return str1.substring(0, gcdLen);
    }

    // Helper function to compute gcd using Euclidean algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
