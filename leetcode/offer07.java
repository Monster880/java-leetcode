class Solution {
    private Map<Integer, Integer> map;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int preRoot = preLeft;
        int inRoot = map.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftSize = inRoot - inLeft;
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRoot - 1);
        root.right = myBuildTree(preorder, inorder, preLeft + leftSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}