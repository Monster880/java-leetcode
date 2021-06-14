/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        Map<Integer, ListNode> have = new HashMap<>();
        have.put(0, dummyNode);
        for(int sum = 0; head != null; head = head.next){
            sum += head.val;
            if(have.containsKey(sum)){
                ListNode temp = have.get(sum);
                for(int s = sum; temp.next != head; have.remove(s += temp.next.val), temp.next = temp.next.next);
                temp.next = temp.next.next;
            }else{
                have.put(sum, head);
            }
        }
        return dummyNode.next;
    }
}