class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;
            int c_bit = (c >> i) & 1;

            if (c_bit == 1) {
                // Case: we want (a_bit | b_bit) = 1
                if (a_bit == 0 && b_bit == 0)
                    flips += 1;
            } else {
                // Case: we want (a_bit | b_bit) = 0
                flips += a_bit + b_bit;  // flip any 1s to 0
            }
        }

        return flips;
    }
}
