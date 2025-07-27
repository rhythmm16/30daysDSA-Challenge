class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            int dist = Math.abs(x) + Math.abs(y);

            // You can increase the distance by at most 2 for each change
            // But only if it's needed to increase it
            max = Math.max(max, Math.min(dist + 2 * k, i + 1));
        }

        return max;
    }
}
