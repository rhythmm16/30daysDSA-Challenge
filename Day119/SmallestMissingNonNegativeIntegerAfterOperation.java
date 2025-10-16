class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        
        // Count occurrences modulo value
        for (int num : nums) {
            int r = ((num % value) + value) % value;  // normalize negative remainders
            cnt[r]++;
        }
        
        int mex = 0;
        while (true) {
            int r = mex % value;
            if (cnt[r] == 0) break; // can't represent this number
            cnt[r]--; // use one occurrence
            mex++;
        }
        return mex;
    }
}
