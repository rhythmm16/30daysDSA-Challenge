import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Convert arrays to sets to remove duplicates
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        
        // Create result lists
        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        
        // Elements in set1 but not in set2
        for (int n : set1) {
            if (!set2.contains(n)) diff1.add(n);
        }
        
        // Elements in set2 but not in set1
        for (int n : set2) {
            if (!set1.contains(n)) diff2.add(n);
        }
        
        return Arrays.asList(diff1, diff2);
    }
}
