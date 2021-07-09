class Solution {
    public int shortestBridge(int[][] A) {
        int[][] direction = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Deque<int []> queue = new ArrayDeque<>();
        int ans = -1;
        boolean[][] visited = new boolean[A.length][A[0].length];
        boolean flag = true;
        for(int i=0; i< A.length&&flag; i++){
            for(int j=0; j<A[0].length;j++){
                if(A[i][j] == 1){
                    dfs(A,i,j, queue, visited);
                    flag = false;
                    break;
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int i=0; i<size; i++){
                int[] node = queue.poll();
                for(int j=0; j<4; j++){
                    int dx = node[0] + direction[j][0];
                    int dy = node[1] + direction[j][1];
                    if(dx < 0 || dx >= A.length || dy<0 || dy >= A[0].length || visited[dx][dy]) continue;
                    if(A[dx][dy] == 1) return ans;
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] A, int i, int j, Deque queue, boolean[][] visited){
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || visited[i][j] || A[i][j] !=1 )    return;
        visited[i][j] = true;
        queue.add(new int[]{i,j});
        dfs(A, i-1, j, queue, visited);
        dfs(A, i+1, j, queue, visited);
        dfs(A, i, j-1, queue, visited);
        dfs(A, i, j+1, queue, visited);
    }
}