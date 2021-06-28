class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        for(int i=1; i< nums.length; i++){
            if(!q.isEmpty() && q.peek() < i - k){
                q.pop();
            }
            nums[i] += nums[q.peek()];
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.removeLast();
            }
            q.add(i);
        }
        return nums[nums.length - 1];
    }
}