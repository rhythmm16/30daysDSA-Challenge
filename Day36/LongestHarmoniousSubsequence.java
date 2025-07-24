import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Step 2: Find valid harmonious subsequence pairs
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                int length = freqMap.get(key) + freqMap.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
