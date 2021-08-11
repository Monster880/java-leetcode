class Solution {
    List<Integer> list = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums){
        if(cur == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(false, cur+1, nums);
        if(!choosePre && cur > 0 && nums[cur - 1] == nums[cur]){
            return;
        }
        list.add(nums[cur]);
        dfs(true, cur + 1, nums);
        list.remove(list.size() -1);
    }
}