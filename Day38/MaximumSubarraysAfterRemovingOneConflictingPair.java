import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long total = (long) n * (n + 1) / 2;

        // Map each pair to its conflict cost
        Map<Integer, List<Integer>> conflictMap = new HashMap<>();
        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            conflictMap.computeIfAbsent(Math.min(a, b), k -> new ArrayList<>()).add(Math.max(a, b));
        }

        // Compute subarrays invalidated by all pairs
        Map<String, Long> pairToInvalidCount = new HashMap<>();
        long totalInvalid = 0;

        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            if (a > b) { int temp = a; a = b; b = temp; }

            long invalid = (long) a * (n - b + 1);
            totalInvalid += invalid;
            pairToInvalidCount.put(a + "," + b, invalid);
        }

        // Try removing each pair and find max valid subarrays
        long maxValid = 0;
        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            if (a > b) { int temp = a; a = b; b = temp; }

            String key = a + "," + b;
            long removedInvalid = pairToInvalidCount.getOrDefault(key, 0L);
            long currentValid = total - (totalInvalid - removedInvalid);
            maxValid = Math.max(maxValid, currentValid);
        }

        return maxValid;
    }
}
