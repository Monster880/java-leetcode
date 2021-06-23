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

    public TreeNode helper(int[] inorder, int inStart, int inEnd,int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        for(int i=inStart; i <= inEnd; i++){
            if(inorder[i] == postorder[postEnd]){
                root.left = helper(inorder, inStart, i-1, postorder, postStart, postStart+i-1-inStart);
                root.right = helper(inorder, i+1, inEnd, postorder, postStart+i-inStart, postEnd-1);
            }
        }
        return root;        
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        TreeNode root = helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }
}