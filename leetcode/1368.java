class Solution {
    private static int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                d[i][j] = -1;
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Arrays.compare(a,b));
        for(q.add(new int[]{0, 0, 0}); d[m-1][n-1] < 0;){
            int[] temp = q.poll();
            if(d[temp[1]][temp[2]] >= 0){
                continue;
            }
            d[temp[1]][temp[2]] = temp[0];
            for(int i=0;i<4;i++){
                int x = temp[1]+dx[i], y = temp[2]+dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && d[x][y] < 0){
                    q.add(new int[]{temp[0]+ (grid[temp[1]][temp[2]] == i + 1 ? 0 : 1), x, y});
                }
            }
        }
        return d[m-1][n-1];
    }
}