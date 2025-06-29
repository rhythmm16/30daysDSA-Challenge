class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Dummy node to handle edge cases (like left = 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move `prev` to just before the `left` node
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Reverse the sublist from `left` to `right`
        ListNode curr = prev.next;
        ListNode next = null;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;

            // Standard reversal process
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
