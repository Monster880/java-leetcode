class Solution {
    public int[][] res;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n+2];
        for(int i=1;i <= n;i++){
            val[i] = nums[i-1];
        }
        val[0] = val[n+1] = 1;
        res = new int[n+2][n+2];
        for(int i=0; i<=n+1; i++){
            Arrays.fill(res[i], -1);
        }
        return dfs(0, n+1);
    }

    public int dfs(int left, int right){
        if(left >= right - 1){
            return 0;
        }
        if(res[left][right] != -1){
            return res[left][right];
        }
        for(int i=left+1; i < right; i++){
            int sum = val[left] * val[i] * val[right];
            sum += dfs(left, i) + dfs(i, right);
            res[left][right] = Math.max(res[left][right], sum);
        }
        return res[left][right];
    }
}