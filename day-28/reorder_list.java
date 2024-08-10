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
    public void reorderList(ListNode head) {
        //ListNode ans = new ListNode();
        ListNode current = head;
        Stack<Integer> stk = new Stack<>();
        int length = getLength(head);
        
        for (int i = 0; i < length / 2; i++) {
            current = current.next;
        }
        while (current != null) {
            stk.push(current.val);
            current = current.next;
        }

        while (!stk.isEmpty() && length != 1) {
            System.out.print(head.val+" ");
            head = head.next;
            System.out.print(stk.peek() + " ");
            stk.pop();
            length--;

        }


        //System.out.print("length of the linked list is "+ getLength(head));
    }
    public int getLength(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
}