/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    //lets declare global variable that holds previous value
    //to compare with 1st element this will have  value less than given lower 
    //bound   Constraints (-2^31)
    long preVal= Long.MIN_VALUE ;

    // lets declare one global isValid variable and set it to true;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        
        inorder(root);
        return isValid;
    }
    //this is basic inorder traversal
    public void inorder(TreeNode root){

        if(root == null) return ;
        //goto left ...
        inorder(root.left);

        //here we will check if previous value is greater than or equal to current value 
        //if its equal or greater then this is not valid tree...
        if(preVal>=root.val)isValid = false;
        preVal = root.val;

        // goto right ...
        inorder(root.right);
    }
}