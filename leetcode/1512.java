class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int num : nums){
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            int v = entry.getValue();
            ans += v * (v-1) / 2;
        }
        return ans;
    }
}