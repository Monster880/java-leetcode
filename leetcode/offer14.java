class Solution {
    public int cuttingRope(int n) {
        if(n < 4) return n-1;

        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i=5;i<n+1;i++){
            dp[i]=Math.max(dp[i-1],Math.max(dp[i-2]*2,dp[i-3]*3));
        }
        return dp[n];
    }
}