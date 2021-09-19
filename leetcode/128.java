class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int cur = num;
                int length = 1;
                while(set.contains(cur + 1)){
                    cur++;
                    length++;
                }
                res = Math.max(res, length);
            }            
        }
        return res;
    }
}