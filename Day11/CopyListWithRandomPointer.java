class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Copy nodes and insert them just after the original ones
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Detach the copied list from the original list
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node next = curr.next.next;

            // Extract the copy
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            // Restore the original list
            curr.next = next;
            curr = next;
        }

        return dummy.next;
    }
}
