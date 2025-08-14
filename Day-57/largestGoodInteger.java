class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            // Check if all 3 digits are the same
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                // Compare lexicographically to keep the largest
                if (max.equals("") || sub.compareTo(max) > 0) {
                    max = sub;
                }
            }
        }
        
        return max;
    }
}
