class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; // count the point itself

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    // duplicate point
                    duplicate++;
                } else {
                    // Reduce the slope (dy/dx) to its simplest form using GCD
                    int gcd = gcd(dy, dx);
                    dx /= gcd;
                    dy /= gcd;

                    // Handle sign to avoid different keys for same slope
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String slopeKey = dy + "/" + dx;
                    slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                }
            }

            int currMax = 0;
            for (int count : slopeMap.values()) {
                currMax = Math.max(currMax, count);
            }

            max = Math.max(max, currMax + duplicate);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
