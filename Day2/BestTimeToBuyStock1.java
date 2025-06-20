class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minPrice if we find a new lower price
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate profit if selling today, and update maxProfit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
