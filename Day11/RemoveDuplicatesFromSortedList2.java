class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // If current node is duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Link prev to the node after duplicates
                prev.next = head.next;
            } else {
                // No duplicate, move prev
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }

        return dummy.next;
    }
}
