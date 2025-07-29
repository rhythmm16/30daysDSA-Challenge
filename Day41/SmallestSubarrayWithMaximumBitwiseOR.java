class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] bitLastSeen = new int[32]; // last seen position for each bit
        Arrays.fill(bitLastSeen, -1);

        for (int i = n - 1; i >= 0; i--) {
            // Update the last seen index for all bits set in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    bitLastSeen[b] = i;
                }
            }

            // Find the farthest position we need to go to OR all bits seen so far
            int maxPos = i;
            for (int b = 0; b < 32; b++) {
                if (bitLastSeen[b] != -1) {
                    maxPos = Math.max(maxPos, bitLastSeen[b]);
                }
            }

            answer[i] = maxPos - i + 1;
        }

        return answer;
    }
}
