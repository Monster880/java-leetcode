class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int pre=1,dp=1;
        int ans=1;
        if(n == 0) return 0;
        int[] map = new int[257];
        map[s.charAt(0)]=1;
        for(int i=1;i<n;++i){ 
            dp=Math.min(i+1-map[s.charAt(i)],pre+1);
            map[s.charAt(i)]=i+1;
            pre = dp;
            ans=Math.max(ans,dp);
        }
        return ans;
    }
}