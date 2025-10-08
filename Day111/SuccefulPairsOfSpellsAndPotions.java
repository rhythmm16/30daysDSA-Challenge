import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // ceil division
            int idx = binarySearch(potions, minPotion);
            res[i] = m - idx;
        }
        return res;
    }
    
    private int binarySearch(int[] potions, long target) {
        int l = 0, r = potions.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l; // first index where potion >= target
    }
}
