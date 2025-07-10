import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // lower half (max heap)
    private PriorityQueue<Integer> minHeap; // upper half (min heap)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        minHeap = new PriorityQueue<>(); // Min Heap
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap
        maxHeap.offer(num);
        
        // Step 2: Balance - move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Ensure size property (maxHeap >= minHeap)
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
