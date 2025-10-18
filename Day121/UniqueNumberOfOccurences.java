import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Store frequencies in a HashSet to check uniqueness
        Set<Integer> uniqueFreq = new HashSet<>(freq.values());
        
        // If size of map values == size of unique set, all frequencies are unique
        return freq.size() == uniqueFreq.size();
    }
}
