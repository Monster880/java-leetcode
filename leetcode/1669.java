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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = list1;
        int i=0;
        for(; list1 != null && ++i != a; list1 = list1.next);
        ListNode pre = list1;
        list1 = list1.next;
        for(;list1 != null && i++ != b; list1 = list1.next);
        ListNode tail = list1.next;
        ListNode cur = pre;
        while(list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        cur.next = tail;
        return dummyNode.next;
    }
}