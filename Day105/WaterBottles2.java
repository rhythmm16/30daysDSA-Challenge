class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        int exchangeCost = numExchange;

        while (empty >= exchangeCost) {
            // Perform one exchange
            empty -= exchangeCost;   // spend empty bottles
            total++;                 // drink new full bottle
            empty++;                 // that bottle becomes empty
            exchangeCost++;          // next exchange is more costly
        }

        return total;
    }
}
