class Solution {
    private int getLen(int x){
        if(x == 1){
            return 1;
        }else if(x < 10){
            return 2;
        }else if(x < 100){
            return 3;
        }else{
            return 4;
        }
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n;i++){
            char c = s.charAt(i-1);
            for(int j=0; j<=k;j++){
                dp[i][j] = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                for(int p=i-1,num=0,t=j;p>=0;p--){
                    if(s.charAt(p) == c){
                        ++num;
                    }else if(--t < 0){
                        break;
                    }
                    dp[i][j] = Math.min(dp[i][j], getLen(num) + dp[p][t]);
                }
            }
        }
        return dp[n][k];
    }
}