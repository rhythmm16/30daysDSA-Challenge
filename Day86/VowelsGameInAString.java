class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                return true; // Alice can win
            }
        }
        return false; // no vowels -> Alice cannot move
    }
}
