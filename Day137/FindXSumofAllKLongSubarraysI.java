import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            
            // count frequency for current window
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // sort elements by frequency desc, value desc
            List<int[]> elements = new ArrayList<>();
            for (var e : freq.entrySet()) {
                elements.add(new int[]{e.getKey(), e.getValue()});
            }

            elements.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // higher freq first
                return b[0] - a[0]; // larger value first
            });

            // take top x elements
            Set<Integer> keep = new HashSet<>();
            for (int t = 0; t < Math.min(x, elements.size()); t++) {
                keep.add(elements.get(t)[0]);
            }

            // compute x-sum
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (keep.contains(nums[j])) sum += nums[j];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
dai