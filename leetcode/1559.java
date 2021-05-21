class Solution {
    private static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    private boolean[][] mark;
    private boolean dfs(char[][] grid, int x, int y, int lastx, int lasty){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != grid[lastx][lasty]){
            return false;
        }
        if(mark[x][y]){
            return true;
        }
        mark[x][y] = true;
        for(int i=0;i<4;i++){
            int xx = x + dx[i], yy = y + dy[i];
            if((xx != lastx || yy != lasty) && dfs(grid, xx, yy, x, y)){
                return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        mark = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(!mark[i][j] && dfs(grid,i,j,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}