class Solution {
    private static int M =1000000007;

    int mul(long x,long y){
        return (int)(x * y % M);
    }
    int add(int x,int y){
        if((x += y) >= M){
            x -= M;
        }
        return x;
    }

    public int numMusicPlaylists(int N, int L, int K) {
        int[][] dp = new int[L+1][N+1];
        for(int i=dp[0][0] =1; i<=L;i++){
            for(int j=1; j<=i && j<=N;j++){
                dp[i][j] = add(mul(dp[i-1][j-1], N-j+1), j>K ? mul(dp[i-1][j],j-K) : 0);
            }
        }
        return dp[L][N];
    }
}