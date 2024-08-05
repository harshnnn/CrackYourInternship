/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // storing answer node
    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        traverse(root, p, q);
        return node;

    }

    boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = traverse(root.left, p, q);
        boolean right = traverse(root.right, p, q);

        /* CHECK 1: the case left && right is to handle
           the case where both p and q are having seperate 
           common ancestor node.

           CHECK 2: the case (left || right) && root == p is to handle
           the case where root is node p then this node has q as its
           either left or right child.

           CHECK 3: the case (left || right) && root == q is to handle
           the case where root is node q then this node has p as its 
           either left or right child.

           if any of these CHECK is true, then the lowest common ancetor 
           will be the root.

           NOTE: this below codes are getting executed when the 
           recursive functions are getting popped from the stack memory.
        */
        if (left && right || ((left || right) && root == p) || ((left || right) && root == q)) {
            node = root;
        }
        if (root == p || root == q) {
            return true;
        }
        
        return left || right;

    }

}