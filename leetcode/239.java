class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-(k-1)];
        Deque<Integer> q = new LinkedList<>();
        for(int i =0; i<nums.length; i++){
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(i);
            int left = i + 1 - k;
            if(q.peekFirst() < left){
                q.pollFirst();
            }
            if(left >= 0){
                res[left] = nums[q.peekFirst()];
            }
        }
        q.clear();
        return res;
    }
}