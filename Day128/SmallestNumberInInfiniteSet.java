import java.util.*;

class SmallestInfiniteSet {
    private int current;
    private TreeSet<Integer> addedBack;

    public SmallestInfiniteSet() {
        current = 1;
        addedBack = new TreeSet<>();
    }

    public int popSmallest() {
        // If we have any smaller numbers added back, pop from TreeSet
        if (!addedBack.isEmpty()) {
            int smallest = addedBack.pollFirst();
            return smallest;
        }

        // Otherwise return current and move to next
        return current++;
    }

    public void addBack(int num) {
        // Only add if num < current and not already in set
        if (num < current) {
            addedBack.add(num);
        }
    }
}
