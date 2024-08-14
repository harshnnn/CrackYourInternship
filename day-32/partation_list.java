class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;  
        ListNode lessDummy = new ListNode(0);    
        ListNode lessTail = lessDummy;             
        ListNode greaterDummy = new ListNode(0); 
        ListNode greaterTail = greaterDummy;     
        
        while (current != null) {
            if (current.val < x) {

                lessTail.next = new ListNode(current.val);
                lessTail = lessTail.next; 
            } else {

                greaterTail.next = new ListNode(current.val);
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }
     
        lessTail.next = greaterDummy.next;
        return lessDummy.next;
    }
}