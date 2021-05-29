/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private Pair<ListNode, ListNode> reverse(ListNode head){
        if(head == null || head.next == null){
            return new Pair<>(head, head);
        }
        Pair<ListNode, ListNode> temp = reverse(head.next);
        temp.getValue().next = head;
        head.next = null;
        return new Pair<>(temp.getKey(), head);
    }
    
    public ListNode reverseList(ListNode head) {
        return reverse(head).getKey();
    }
}