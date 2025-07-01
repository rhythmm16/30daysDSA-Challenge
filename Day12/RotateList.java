class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and last node
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Make it circular
        curr.next = head;

        // Step 3: Find new head and tail
        k = k % length;
        int stepsToNewTail = length - k;
        ListNode newTail = curr; // currently pointing to last node
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break the circle and return new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
