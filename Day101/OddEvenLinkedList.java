/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;           // pointer for odd-indexed nodes
        ListNode even = head.next;     // pointer for even-indexed nodes
        ListNode evenHead = even;      // keep the head of even nodes to attach later

        while (even != null && even.next != null) {
            odd.next = even.next;      // link next odd node
            odd = odd.next;            // move odd pointer
            even.next = odd.next;      // link next even node
            even = even.next;          // move even pointer
        }

        odd.next = evenHead;           // attach even list at the end of odd list
        return head;
    }
}
