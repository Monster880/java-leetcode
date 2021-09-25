class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int num : nums){
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i < n; i++){
            if(nums[i] <= n){
                res.add(i+1);
            }
        }
        return res;
    }
}