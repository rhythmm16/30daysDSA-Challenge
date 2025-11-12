class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int num : nums) if (num == 1) ones++;
        if (ones > 0) return n - ones; // case 1

        int minLen = Integer.MAX_VALUE;
        // find shortest subarray with gcd == 1
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // stop expanding, no need to go further
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : (minLen - 1 + n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
