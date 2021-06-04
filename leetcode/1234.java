class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int[][] num = new int[n+1][4];
        for(int i=1; i<=n;i++){
            for(int j=0; j<4;j++){
                num[i][j] = num[i-1][j];
            }
            ++num[i]["QWER".indexOf(s.charAt(i-1))];
        }
        int r = n;
        for(int i=0, j=0,m = n/4; j<=n;i++){
            for(j = Math.max(i,j); j<=n && (
            num[n][0] + num[i][0] - num[j][0] > m || 
            num[n][1] + num[i][1] - num[j][1] > m || 
            num[n][2] + num[i][2] - num[j][2] > m ||
            num[n][3] + num[i][3] - num[j][3] > m);j++
            );
            if(j <= n){
                r = Math.min(r, j-i);
            }
        }
        return r;
    }
}