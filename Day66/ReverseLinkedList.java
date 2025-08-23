class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;      // initially nothing before head
        ListNode curr = head;      // start with head

        while (curr != null) {
            ListNode nextNode = curr.next; // save next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head of reversed list
    }
}
