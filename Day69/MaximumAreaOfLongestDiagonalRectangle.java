class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = -1;  // store max diagonal squared
        int maxArea = -1;      // store max area for longest diagonal
        
        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w; // diagonal squared
            int area = l * w;
            
            if (diagSq > maxDiagonal) {
                maxDiagonal = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}
