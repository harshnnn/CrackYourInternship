class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the node is null then the leafnode is not achieved yet because that is covered in the below condition
        // Also this checks if the root of the tree is null
        if(root==null) return false;
        
        // If the node is the leafnode then it has to be equal to the remaining targetSum
        if(root.left==null && root.right==null) return root.val==targetSum; 
        
        // Check for both left and right tree by reducing the current node value
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}