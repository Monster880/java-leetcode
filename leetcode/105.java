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
    private TreeNode dfs(int[] preorder, int[] inorder,int from1,int from2,int len){
        if(len == 0){
            return null;
        }
        int i = from2;
        for(; preorder[from1] != inorder[i]; i++);     
        TreeNode root = new TreeNode(preorder[from1]);
        root.left = dfs(preorder, inorder, from1+1, from2, i-from2);
        root.right = dfs(preorder, inorder, from1+1+i-from2, i+1, len-1-i+from2);
        return root;   
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,0,0,preorder.length);
    }
}