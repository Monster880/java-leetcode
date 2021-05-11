class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int i=0;i<nums.length/k;i++){
            int x = map.firstKey();
            for(int j=0;j<k;j++,x++){
                int c = map.getOrDefault(x, 0);
                if(c == 0){
                    return false;
                }else if(--c > 0){
                    map.put(x,c);
                }else{
                    map.remove(x);
                }
            }
        }
        return true;
    }
}