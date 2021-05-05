class Solution {
    private int better(int x,int y){
        return x < 0 || x > y ? y : x;
    }
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> have = new HashMap<>();
        have.put(0,0);
        int[] dp = new int[arr.length+1];
        int r = -1;
        dp[0] = -1;
        for(int i=1, s= 0; i <= arr.length;i++){
            s += arr[i-1];
            dp[i] = dp[i-1];
            int want = s - target;
            if(have.containsKey(want)){
                int p = have.get(want);
                int len = i - p;
                dp[i] = better(dp[i], len);
                if(dp[p] >= 0){
                    r = better(r, dp[p] + len);
                }
            }
            have.put(s,i);
        }
        return r;
    }
}