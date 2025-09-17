import java.util.*;

class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<String>> cuisineToHeap;
    private Map<String, PriorityQueue<int[]>> cuisineToPQ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToPQ = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);

            cuisineToPQ.putIfAbsent(c, new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                return foods[a[1]].compareTo(foods[b[1]]);
            }));
        }

        for (int i = 0; i < foods.length; i++) {
            String c = cuisines[i];
            cuisineToPQ.get(c).offer(new int[]{ratings[i], i});
        }
    }

    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String c = foodToCuisine.get(food);
        cuisineToPQ.get(c).offer(new int[]{newRating, indexOf(food)});
    }

    public String highestRated(String cuisine) {
        PriorityQueue<int[]> pq = cuisineToPQ.get(cuisine);
        while (true) {
            int[] top = pq.peek();
            String food = getFood(top[1]);
            if (foodToRating.get(food) == top[0]) return food;
            pq.poll();
        }
    }

    private String[] foodList;
    private Map<String, Integer> foodIndex = new HashMap<>();

    private int indexOf(String food) {
        if (foodList == null) return -1;
        return foodIndex.get(food);
    }

    private String getFood(int idx) {
        return foodList[idx];
    }
}
