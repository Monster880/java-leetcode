/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        root.left = pre;
        if(pre == null){
            head = root;
        }else{
            pre.right = root;
        }
        pre = root;
        inOrder(root.right);
    }
}