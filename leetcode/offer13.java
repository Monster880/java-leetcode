class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        int ans = 1;
        visited[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    visited[i][j] |= visited[i - 1][j];
                }
                if (j - 1 >= 0) {
                    visited[i][j] |= visited[i][j - 1];
                }
                ans += visited[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}