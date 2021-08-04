class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int num2, num3, num5, num;
        for (int i = 1; i < n; i++) {
            num2 = dp[p2] * 2;
            num3 = dp[p3] * 3;
            num5 = dp[p5] * 5;
            num = Math.min(num2, Math.min(num3, num5));
            dp[i] = num;
            if (num == num2) {
                p2++;
            }
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}