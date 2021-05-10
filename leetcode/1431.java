class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int m = 0;
        for(int x : candies){
            m = Math.max(x,m);
        }
        m -= extraCandies;
        List<Boolean> ans = new ArrayList<>();
        for(int x: candies){
            ans.add(x >= m);
        }
        return ans;
    }
}