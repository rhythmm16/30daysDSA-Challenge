class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Give 1 candy to each child
        Arrays.fill(candies, 1);

        // Step 2: Left to right - if right child has higher rating, give more candy than left
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right to left - if left child has higher rating, ensure more candy than right
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up the candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}
