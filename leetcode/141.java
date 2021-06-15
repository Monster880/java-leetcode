/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        for(ListNode t1 = head, t2 = head;;){
            if(t2 == null){
                return false;
            }
            t2 = t2.next;
            if(t2 == null){
                return false;
            }
            t2 = t2.next;
            t1 = t1.next;
            if(t1 == t2){
                return true;
            }
        }
    }
}