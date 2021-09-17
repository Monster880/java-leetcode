class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode curNode = head;
        while(curNode != null){
            list.add(curNode.val);
            curNode = curNode.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while(front < back){
            if(!list.get(front).equals(list.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}