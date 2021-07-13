class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int lsum = 0, rsum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            rsum += 1 - nums[right];
            while(lsum < rsum - k){
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right-left +1);
        }
        return ans;
    }
}