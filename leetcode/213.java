class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    public int robRange(int[] nums, int start, int end){
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for(int i=start+2; i<=end; i++){
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        return second;
    }
}