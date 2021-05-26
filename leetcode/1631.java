class Solution {
    private static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] mark = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Arrays.compare(a, b));
        for(q.add(new int[] {0, 0, 0}); !q.isEmpty();){
            int[] temp = q.poll();
            if(mark[temp[1]][temp[2]]){
                continue;
            }
            mark[temp[1]][temp[2]] = true;
            if(temp[1] == m - 1 && temp[2] == n -1){
                return temp[0];
            }
            for(int i=0; i< 4;i++){
                int x = temp[1] + dx[i], y = temp[2] + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n){
                    q.add(new int[]{Math.max(temp[0], Math.abs(heights[temp[1]][temp[2]] - heights[x][y])), x, y});
                }
            }
        }
        return -1;
    }
}