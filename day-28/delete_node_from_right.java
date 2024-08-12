class Solution
{
    Node compute(Node head)
    {
        // your code here
        
        //1 Reverse LL
        
        head = rev(head);
        
        
        //2.Leaders in an array
        int maxVal = head.data;
        Node curr = head.next, prev= head;
        while(curr !=null ){
            if(curr.data >=maxVal){
                prev=curr;
                maxVal = curr.data;
            }
            // curr.data < maxVal
            else{
                prev.next = curr.next;
            }
            curr =curr.next;
        }
        return rev(head);
        
    }
    
    Node rev(Node head){
        Node curr=head , prev=null, temp=null;
        while(curr !=null){
            temp =curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }
}