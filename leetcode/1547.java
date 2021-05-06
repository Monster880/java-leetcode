class Solution {
    public int minCost(int n, int[] cuts) {
        int[] c = new int[cuts.length + 2];
        c[1] = n;
        System.arraycopy(cuts, 0, c, 2, cuts.length);
        Arrays.sort(c);
        int m = c.length;
        int[][] dp = new int[m][m];
        for(int d=2;d<m;d++){
            for(int i=0;i+d<m;i++){
                int j=i+d;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
                dp[i][j] += c[j] - c[i];
            }
        }
        return dp[0][m-1];
    }
}