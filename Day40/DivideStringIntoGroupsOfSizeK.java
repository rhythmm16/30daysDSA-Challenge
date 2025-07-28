class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groupCount = (n + k - 1) / k; // ceiling division for total number of groups
        String[] result = new String[groupCount];
        
        int index = 0;
        for (int i = 0; i < groupCount; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = 0; j < k; j++) {
                if (index < n) {
                    group.append(s.charAt(index++));
                } else {
                    group.append(fill);
                }
            }
            result[i] = group.toString();
        }
        
        return result;
    }
}
