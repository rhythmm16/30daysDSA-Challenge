class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapST = new int[256]; // mapping from s to t
        int[] mapTS = new int[256]; // mapping from t to s

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If not previously mapped, map it
            if (mapST[c1] == 0 && mapTS[c2] == 0) {
                mapST[c1] = c2;
                mapTS[c2] = c1;
            } 
            // If previously mapped, check consistency
            else {
                if (mapST[c1] != c2 || mapTS[c2] != c1) return false;
            }
        }

        return true;
    }
}
