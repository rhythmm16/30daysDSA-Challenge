class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Count frequency of each unique value
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int maxFreq = 0;
        
        // For each unique value as a potential target
        for (int target : freq.keySet()) {
            int atTarget = freq.get(target);
            
            // Use binary search to find range [target-k, target+k]
            int left = lowerBound(nums, target - k);
            int right = upperBound(nums, target + k);
            int reachable = right - left;
            
            // Maximum we can achieve
            int needTransform = reachable - atTarget;
            int achievable = atTarget + Math.min(numOperations, needTransform);
            maxFreq = Math.max(maxFreq, achievable);
        }
        
        // Also check values that don't exist but are reachable
        // Use a sweep line approach for all ranges
        Map<Integer, Integer> rangeCount = new TreeMap<>();
        for (int num : nums) {
            rangeCount.put(num - k, rangeCount.getOrDefault(num - k, 0) + 1);
            rangeCount.put(num + k + 1, rangeCount.getOrDefault(num + k + 1, 0) - 1);
        }
        
        int currentCount = 0;
        for (Map.Entry<Integer, Integer> entry : rangeCount.entrySet()) {
            currentCount += entry.getValue();
            // For non-existing values, all elements need transformation
            int target = entry.getKey();
            if (!freq.containsKey(target) && currentCount > 0) {
                int achievable = Math.min(numOperations, currentCount);
                maxFreq = Math.max(maxFreq, achievable);
            }
        }
        
        return maxFreq;
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}