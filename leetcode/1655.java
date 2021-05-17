class Solution {
    private boolean backTrack(int[] maps, int[] quantity, int index){
        if(index < 0) return true;
        for(int i=0; i<maps.length;i++){
            if(i != 0 && maps[i] == maps[i-1]){
                continue;
            }
            if(maps[i] >= quantity[index]){
                maps[i] -= quantity[index];
                if(backTrack(maps, quantity, index-1)) return true;
                maps[i] += quantity[index];
            }
        }
        return false;
    }

    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] map = new int[1001];
        for(int i=0;i<nums.length;i++){
            map[nums[i]]++;
        }
        Arrays.sort(map);
        int[] maps = Arrays.copyOfRange(map, map.length-50, map.length);
        Arrays.sort(quantity);
        return backTrack(maps, quantity, quantity.length - 1);
    }
}