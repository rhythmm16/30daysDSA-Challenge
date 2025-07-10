import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of size k
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // remove the smallest
            }
        }

        // Top of the heap is the kth largest
        return heap.peek();
    }
}
