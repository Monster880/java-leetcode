/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int r = 0;
        for(; head != null; head = head.next){
            r = (r << 1) | head.val;
        }
        return r;
    }
}