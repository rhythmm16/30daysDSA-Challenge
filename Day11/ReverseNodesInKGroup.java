class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge case
        if (head == null || k == 1) return head;

        // Dummy node initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        // Count total number of nodes
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Reverse in k-groups
        current = dummy.next;
        while (count >= k) {
            ListNode groupStart = current;
            ListNode prev = null;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect previous group to reversed
            prevGroupEnd.next = prev;
            groupStart.next = current;
            prevGroupEnd = groupStart;

            count -= k;
        }

        return dummy.next;
    }
}
