public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += (n & 1);  // Add 1 if the last bit is 1
            n >>>= 1;          // Unsigned right shift to check next bit
        }
        
        return count;
    }
}
