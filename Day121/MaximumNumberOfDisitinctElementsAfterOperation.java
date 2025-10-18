import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        long curr = Long.MIN_VALUE; // last used distinct number
        int count = 0;

        for (int num : nums) {
            long low = (long) num - k;
            long high = (long) num + k;

            // Choose the next available distinct number
            long next = Math.max(curr + 1, low);

            if (next <= high) {
                count++;
                curr = next;
            }
        }

        return count;
    }
}
