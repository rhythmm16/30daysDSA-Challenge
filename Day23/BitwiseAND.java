public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Find the common prefix of left and right
        while (left < right) {
            right = right & (right - 1); // Remove the rightmost set bit
        }
        return right;
    }
}
