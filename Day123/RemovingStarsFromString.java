class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1); // remove the last char
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
