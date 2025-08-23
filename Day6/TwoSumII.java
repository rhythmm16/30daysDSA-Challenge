class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed
            } else if (sum < target) {
                left++; // Need a bigger number
            } else {
                right--; // Need a smaller number
            }
        }

        return new int[]{-1, -1}; // Fallback (though not needed as problem guarantees one solution)
    }
}
