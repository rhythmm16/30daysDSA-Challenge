class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            if (isBalanced(i)) return i;
        }
    }

    private boolean isBalanced(int num) {
        int[] freq = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        // Count digit frequencies
        for (char c : digits) {
            freq[c - '0']++;
        }

        // Check each digit’s condition
        for (char c : digits) {
            int d = c - '0';
            if (freq[d] != d) return false;
        }

        return true;
    }
}
