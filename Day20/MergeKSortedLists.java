import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store the nodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge process
        while (!pq.isEmpty()) {
            ListNode min = pq.poll(); // Get smallest node
            current.next = min;
            current = current.next;

            if (min.next != null) {
                pq.add(min.next); // Add next node from the same list
            }
        }

        return dummy.next;
    }
}
