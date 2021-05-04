class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int length = arr.length;
        int dp[] = new int[length+1];
        for(int i=0;i <= length;i++){
            int j = i-1;
            int max = dp[i];
            while((i - j) <= k && j >= 0){
                max = Math.max(max,arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i-j) * max);
                j--;
            }
        }
        return dp[length];
    }
}