import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();      // Stores all unique ORs
        Set<Integer> prev = new HashSet<>();        // ORs ending at previous index

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);                          // Start a new subarray with just this number

            for (int x : prev) {
                curr.add(x | num);                  // Extend previous subarrays with current number
            }

            result.addAll(curr);                    // Add current ORs to global result
            prev = curr;                            // Move forward
        }

        return result.size();
    }
}
