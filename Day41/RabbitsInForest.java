import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each answer
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        int totalRabbits = 0;
        for (int answer : countMap.keySet()) {
            int groupSize = answer + 1; // Size of a color group
            int count = countMap.get(answer);
            
            // Number of full groups needed for this answer
            int groups = (count + groupSize - 1) / groupSize;
            
            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}
