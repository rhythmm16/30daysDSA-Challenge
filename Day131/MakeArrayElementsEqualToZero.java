class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try both directions
                if (isValid(nums, i, 1)) ans++;  // right
                if (isValid(nums, i, -1)) ans++; // left
            }
        }
        return ans;
    }

    private boolean isValid(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();  // simulate without changing original
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }

        // Check if all became zero
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
