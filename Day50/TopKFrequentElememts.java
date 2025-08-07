class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Bucket sort based on frequency
        // Create buckets where index is frequency and each bucket stores list of numbers
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        // Step 3: Collect top k frequent elements from the end (highest frequency)
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null)
                result.addAll(buckets[i]);
        }

        // Step 4: Convert to int[] and return only first k
        return result.stream().mapToInt(i -> i).limit(k).toArray();
    }
}
