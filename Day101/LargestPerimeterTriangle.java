import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // sort in ascending order
        int n = nums.length;

        // Traverse from largest to smallest triple
        for (int i = n - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            // Check triangle inequality
            if (c + b > a) {
                return a + b + c;  // largest perimeter found
            }
        }
        return 0; // no valid triangle
    }
}
