import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Step 1: Lengths must be equal
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] exist1 = new boolean[26];
        boolean[] exist2 = new boolean[26];

        // Step 2: Count frequencies and track which characters exist
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            exist1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            exist2[c - 'a'] = true;
        }

        // Step 3: The sets of characters must be the same
        for (int i = 0; i < 26; i++) {
            if (exist1[i] != exist2[i]) return false;
        }

        // Step 4: Sort frequency arrays and compare
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}
