import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int removeCount = 0;
        int prevEnd = intervals[0][1]; // End of first interval
        
        // Step 2: Iterate over intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap → remove this interval
                removeCount++;
            } else {
                // No overlap → update prevEnd
                prevEnd = intervals[i][1];
            }
        }
        
        return removeCount;
    }
}
