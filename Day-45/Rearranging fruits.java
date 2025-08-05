import java.util.*;

class Solution { 
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        Map<Integer, Integer> totalFreq = new HashMap<>();
        TreeSet<Integer> allFruits = new TreeSet<>();

        int n = basket1.length;

        // Count frequencies
        for (int i = 0; i < n; i++) {
            freq1.put(basket1[i], freq1.getOrDefault(basket1[i], 0) + 1);
            freq2.put(basket2[i], freq2.getOrDefault(basket2[i], 0) + 1);

            totalFreq.put(basket1[i], totalFreq.getOrDefault(basket1[i], 0) + 1);
            totalFreq.put(basket2[i], totalFreq.getOrDefault(basket2[i], 0) + 1);

            allFruits.add(basket1[i]);
            allFruits.add(basket2[i]);
        }

        // If any fruit has an odd total count, it's impossible
        for (int fruit : totalFreq.keySet()) {
            if (totalFreq.get(fruit) % 2 != 0) return -1;
        }

        List<Integer> excess1 = new ArrayList<>();
        List<Integer> excess2 = new ArrayList<>();

        for (int fruit : totalFreq.keySet()) {
            int c1 = freq1.getOrDefault(fruit, 0);
            int c2 = freq2.getOrDefault(fruit, 0);
            int diff = c1 - c2;

            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) {
                    excess1.add(fruit);
                }
            } else if (diff < 0) {
                for (int i = 0; i < (-diff) / 2; i++) {
                    excess2.add(fruit);
                }
            }
        }

        Collections.sort(excess1);
        excess2.sort(Collections.reverseOrder());

        int minFruit = allFruits.first();
        long totalCost = 0;

        for (int i = 0; i < excess1.size(); i++) {
            int a = excess1.get(i);
            int b = excess2.get(i);
            totalCost += Math.min(Math.min(a, b), 2 * minFruit);
        }

        return totalCost;
    }
}
