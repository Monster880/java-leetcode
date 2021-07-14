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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean reachEnd = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(reachEnd && temp != null){
                return false;
            }
            if(temp == null){
                reachEnd = true;
                continue;
            }
            q.add(temp.left);
            q.add(temp.right);
        }
        return true;
    }
}