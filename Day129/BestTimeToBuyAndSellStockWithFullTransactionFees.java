class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];  // Profit when holding a stock
        int notHold = 0;        // Profit when not holding a stock
        
        for (int i = 1; i < n; i++) {
            // Either continue holding or buy today
            hold = Math.max(hold, notHold - prices[i]);
            
            // Either continue not holding or sell today (and pay fee)
            notHold = Math.max(notHold, prices[i] + hold - fee);
        }
        
        // The best profit will be when not holding a stock
        return notHold;
    }
}
