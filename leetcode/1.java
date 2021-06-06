class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> have = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int ind = have.getOrDefault(target-nums[i], -1);
            if(ind >= 0){
                return new int[]{ind, i};
            }
            have.put(nums[i],i);
        }
        return null;
    }
}