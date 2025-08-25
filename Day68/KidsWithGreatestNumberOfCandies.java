class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;

        // Find the maximum number of candies any kid has
        for (int c : candies) {
            maxCandies = Math.max(maxCandies, c);
        }

        // Determine if each kid can have the greatest number of candies
        for (int c : candies) {
            result.add(c + extraCandies >= maxCandies);
        }

        return result;
    }
}
