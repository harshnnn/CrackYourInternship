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
    public int maxDepth(TreeNode root) {
        int ans = dfs(root);
        return ans;
    }
    public static int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftdepth = dfs(node.left);
        int rightdepth = dfs(node.right);
        
        return 1 + Math.max(leftdepth, rightdepth);
    }
}