class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        for(int x : nums){
            s += x;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=nums.length-1, x = 0; i>=0 && s - x >= x; i--){
            x += nums[i];
            ans.add(nums[i]);
        }
        return ans;
    }
}