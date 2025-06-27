import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < nums.length) {
            int start = i;

            // Move i forward while the sequence is continuous
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // Format range string
            if (start == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(nums[start] + "->" + nums[i]);
            }

            i++; // Move to next potential range
        }

        return result;
    }
}
