/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        int n = 0;
        Map<Node, Integer> ind = new HashMap<>();
        for(Node temp = head; temp != null; temp = temp.next){
            ind.put(temp,n++);
        }
        if(n == 0){
            return null;
        }
        Node[] r = new Node[n];
        for(int i=0; i<n; i++){
            r[i] = new Node(0);
        }
        for(n=0; head != null; head = head.next, ++n){
            r[n].val = head.val;
            if(n > 0){
                r[n-1].next = r[n];
            }
            if(head.random != null){
                r[n].random = r[ind.get(head.random)];
            }
        }
        return r[0];
    }
}