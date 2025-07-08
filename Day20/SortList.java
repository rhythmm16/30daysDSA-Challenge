class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split list into two halves
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null; // Break the list into two parts

        // Step 2: Recursively sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // Step 3: Merge the sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Function to find the middle node of the list
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next; // use fast = head.next to get left-biased mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Connect the remaining part
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
