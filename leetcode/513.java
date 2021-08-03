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
    private int value = 0;
    private int Deep = -1;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        dfs(root, 0);
        return value;
    }

    private void dfs(TreeNode root, int deep){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(deep > Deep){
                value = root.val;
                Deep = deep;
            }
        }
        if(root.left != null) dfs(root.left, deep+1);
        if(root.right != null) dfs(root.right, deep+1);
    }
}