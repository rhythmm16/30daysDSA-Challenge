class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Step 1: Sort intervals by end ascending, start descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        // Greedy picks: a > b are last two numbers chosen
        int a = -1, b = -1;
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0], end = in[1];

            boolean aInside = a >= start && a <= end;
            boolean bInside = b >= start && b <= end;

            if (aInside && bInside) {
                // Both are already inside this interval
                continue;
            }

            if (aInside) {
                // Add one more: end
                count++;
                b = a;
                a = end;
            } else {
                // Add two: end-1, end
                count += 2;
                b = end - 1;
                a = end;
            }
        }

        return count;
    }
}
