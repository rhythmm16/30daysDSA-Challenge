class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int[] res = new int[2];
        int idx = 0;

        for (int num : nums) {
            if (seen.contains(num)) {
                res[idx++] = num;
                if (idx == 2) break;
            } else {
                seen.add(num);
            }
        }
        return res;
    }
}
