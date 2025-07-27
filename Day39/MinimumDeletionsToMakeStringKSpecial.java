import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) list.add(f);
        }

        int minDel = Integer.MAX_VALUE;

        // Try all possible base frequencies
        for (int t = 1; t <= Collections.max(list); t++) {
            int deletions = 0;
            for (int f : list) {
                if (f < t) {
                    deletions += f; // must delete all
                } else if (f > t + k) {
                    deletions += f - (t + k); // trim down
                }
            }
            minDel = Math.min(minDel, deletions);
        }

        return minDel;
    }
}
