class Solution {
    private void dfs(int now, int n, boolean[] diag1, boolean[] diag2, boolean[] col, int[] solution, List<List<String>> ans){
        if(now >= n){
            List<String> one = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(j == solution[i] ? 'Q' : '.');
                }
                one.add(sb.toString());
            }
            ans.add(one);
            return;
        }
        for(solution[now] = 0; solution[now] < n; solution[now]++){
            if(!col[solution[now]] && !diag1[solution[now] + now] && !diag2[solution[now] - now + n - 1]){
                col[solution[now]] = diag1[solution[now] + now]
                    = diag2[solution[now] - now + n -1 ] = true;
                dfs(now+1, n, diag1, diag2, col, solution, ans);
                col[solution[now]] = diag1[solution[now] + now]
                    = diag2[solution[now] - now + n -1 ] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0 ,n ,new boolean[2 * n -1], new boolean[2 * n -1], new boolean[n], new int[n], ans);
        return ans.size();
    }
}