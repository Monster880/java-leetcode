class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, res = nums[0];
        for(int x : nums){
            pre = Math.max(pre+x, x);
            res = Math.max(res,pre);
        }
        return res;
    }
}