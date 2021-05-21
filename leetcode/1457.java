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
    private int dfs(TreeNode root, int state, int odd){
        if(root == null){
            return 0;
        }
        int mask = 1 << (root.val - 1);
        if((mask & state) == 0){
            odd++;
        }else{
            odd--;
        }
        state ^= mask;
        if(root.left == null && root.right == null){
            return odd < 2 ? 1 : 0;
        }
        return dfs(root.left, state, odd) + dfs(root.right, state, odd);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0, 0);
    }
}