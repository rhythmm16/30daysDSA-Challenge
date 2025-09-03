class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int xA = points[i][0], yA = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xB = points[j][0], yB = points[j][1];

                if (xA <= xB && yA >= yB) {
                    boolean ok = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];
                        if (xA <= x && x <= xB && yB <= y && y <= yA) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) ans++;
                }
            }
        }
        return ans;
    }
}
