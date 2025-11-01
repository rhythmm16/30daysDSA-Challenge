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

import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Add all nums into a HashSet for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Use dummy node to simplify deletions
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // Step 3: Traverse the list
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                // Skip this node
                curr.next = curr.next.next;
            } else {
                // Move to next node
                curr = curr.next;
            }
        }

        // Step 4: Return modified list
        return dummy.next;
    }
}
