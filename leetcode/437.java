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
    Map<Integer, Integer> prefixMap = new HashMap<>();
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        prefixMap.put(0,1);
        return recur(root, 0);
    }

    public int recur(TreeNode node, int curSum){
        if(node == null){
            return 0;
        }
        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0)+ 1);
        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);
        res = res + left + right;
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        return res;
    }
}