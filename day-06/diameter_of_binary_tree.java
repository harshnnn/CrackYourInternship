
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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    public int longestPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftdepth = longestPath(node.left);
        int rightdepth = longestPath(node.right);

        diameter = Math.max(diameter, leftdepth+ rightdepth);
        
        return 1+Math.max(leftdepth, rightdepth) ;
    }
}