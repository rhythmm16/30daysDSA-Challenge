class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last  = new int[26];
        
        Arrays.fill(first, -1);
        
        // record first and last position of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int count = 0;

        // for each char as outer palindrome character
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1 || first[c] == last[c]) continue;

            boolean[] seen = new boolean[26];

            // collect all middle characters between first and last
            for (int i = first[c] + 1; i < last[c]; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }

            // count distinct middle chars
            for (boolean b : seen) if (b) count++;
        }

        return count;
    }
}
