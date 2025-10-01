class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int empty = 0;
        
        while (numBottles > 0) {
            // Drink all current bottles
            total += numBottles;
            empty += numBottles;
            numBottles = 0;

            // Exchange empty bottles for new ones
            if (empty >= numExchange) {
                numBottles = empty / numExchange; // new full bottles
                empty = empty % numExchange;      // remaining empty
            }
        }
        return total;
    }
}
