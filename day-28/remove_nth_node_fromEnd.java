class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node and point it to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Calculate the length of the linked list
        int length = 0;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // Calculate the position to remove
        int target = length - n;

        // Traverse to the node before the one to be removed
        current = dummy;
        for (int i = 0; i < target; i++) {
            current = current.next;
        }

        // Remove the nth node from the end
        current.next = current.next.next;

        // Return the new head
        return dummy.next;
    }
}
