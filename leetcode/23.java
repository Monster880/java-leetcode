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
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while(true){
            ListNode minNode = null;
            int minPointer = -1;
            for(int i=0;i < length;i++){
                if(lists[i] == null){
                    continue;
                }
                if(minNode == null || lists[i].val < minNode.val){
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if(minPointer == -1){
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyNode.next;
    }
}