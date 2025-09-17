import java.util.*;

class FoodRatings {
    private static class Entry {
        String food;
        int rating;
        Entry(String f, int r) { food = f; rating = r; }
    }

    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<Entry>> cuisinePQ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisinePQ = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            cuisinePQ.putIfAbsent(cuisine, new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) return b.rating - a.rating; // higher rating first
                return a.food.compareTo(b.food); // tie-breaker: lexicographically smaller
            }));
            cuisinePQ.get(cuisine).offer(new Entry(food, ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        // push a new entry with the updated rating; stale entries will be removed lazily
        cuisinePQ.get(cuisine).offer(new Entry(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Entry> pq = cuisinePQ.get(cuisine);
        while (!pq.isEmpty()) {
            Entry top = pq.peek();
            int currRating = foodToRating.get(top.food);
            if (top.rating != currRating) {
                // stale entry, discard
                pq.poll();
            } else {
                return top.food;
            }
        }
        return ""; // should not happen per constraints
    }
}
