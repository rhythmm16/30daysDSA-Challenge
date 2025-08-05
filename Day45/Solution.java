public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases smoothly
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // First and second nodes of the pair
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap the pair
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;
    }
}
