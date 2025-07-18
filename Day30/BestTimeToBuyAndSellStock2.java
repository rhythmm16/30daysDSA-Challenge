class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // Initialize profits:
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);          // Best price to buy first stock
            sell1 = Math.max(sell1, buy1 + price);  // Best price to sell first stock
            buy2 = Math.max(buy2, sell1 - price);   // Best price to buy second stock
            sell2 = Math.max(sell2, buy2 + price);  // Best price to sell second stock
        }

        return sell2; // Max profit with at most two transactions
    }
}
