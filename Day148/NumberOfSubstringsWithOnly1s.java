class Solution {
    public int numSub(String s) {
        long MOD = 1000000007;
        long count = 0;   // counts consecutive 1s
        long result = 0;  // stores total substrings
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;  // increase count for consecutive 1s
                result = (result + count) % MOD;
            } else {
                count = 0;  // reset when 0 is found
            }
        }
        
        return (int) result;
    }
}
