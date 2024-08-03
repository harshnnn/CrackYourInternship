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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        int[] arr = new int[count];

        current = head;
        for(int i = 0 ; i< count; i++){
            arr[i] = current.val;
            current = current.next;
        }

        current = head;
        // Reverse the linked list by updating the node values
        for (int i = count - 1; i >= 0; i--) {
            current.val = arr[i];
            current = current.next;
        }

        return head;
    }
}