class Solution {
    public int numIslands(char[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0; j<A[0].length;j++){
                visited[i][j] = false;
            }
        }
        int ans = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == '1' && !visited[i][j]){
                    dfs(A,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] A, int i, int j, boolean[][] visited){
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || visited[i][j] || A[i][j] == '0') return;
        visited[i][j] = true;
        dfs(A,i+1,j,visited);
        dfs(A,i-1,j,visited);
        dfs(A,i,j+1,visited);
        dfs(A,i,j-1,visited);
    }
}