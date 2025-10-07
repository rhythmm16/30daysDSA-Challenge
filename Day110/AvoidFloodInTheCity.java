import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>(); // lake -> last rain day
        TreeSet<Integer> dryDays = new TreeSet<>();   // indices of 0s
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                ans[i] = 1; // default value
            } else {
                ans[i] = -1;
                if (full.containsKey(lake)) {
                    // find dry day after last rain
                    Integer dry = dryDays.higher(full.get(lake));
                    if (dry == null) return new int[0]; // no dry day found
                    ans[dry] = lake;  // dry this lake
                    dryDays.remove(dry);
                }
                full.put(lake, i);
            }
        }
        return ans;
    }
}
