
class Solution {
    int maxLevel;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        maxLevel=0;
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode root, List<Integer> result, int prevLevel) {
        if(root==null) return;
        int currLevel= prevLevel+1;
        if(currLevel> maxLevel) {
            result.add(root.val);
            maxLevel= currLevel;
        }
        rightView(root.right, result, currLevel);
        rightView(root.left, result, currLevel);
    }
}

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