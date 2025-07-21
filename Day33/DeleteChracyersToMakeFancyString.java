class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int consecutiveCount = 1; // Start with 1 since the first character is always included
        result.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }

            if (consecutiveCount < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
