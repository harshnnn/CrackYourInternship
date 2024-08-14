class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // Reverse both linked lists
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        // Subtract the two numbers
        Node result = subtract(head1, head2);

        // Reverse the result linked list
        result = reverseList(result);

        // Remove leading zeros from the result
        while (result != null && result.val == 0) {
            result = result.next;
        }

        // If result is empty, return a single node with value 0
        if (result == null) {
            return new Node(0);
        }

        return result;
    }

    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Helper function to subtract two linked lists
    private Node subtract(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int borrow = 0;

        while (head1 != null || head2 != null) {
            int x = (head1 != null) ? head1.val : 0;
            int y = (head2 != null) ? head2.val : 0;

            int diff = x - y - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            curr.next = new Node(diff);
            curr = curr.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return dummy.next;
    }
}