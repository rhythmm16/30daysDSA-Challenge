class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) {     // stop before last bit
            if (bits[i] == 1) {
                i += 2;         // skip 2-bit character
            } else {
                i += 1;         // skip 1-bit character
            }
        }

        return i == n - 1;      // true if last bit stands alone
    }
}
