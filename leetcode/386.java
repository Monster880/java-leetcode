class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, n, 0);
        return res;
    }

    private void dfs(List<Integer> res, int n, int val){
        for(int i=0; i<=9; i++){
            if(val == 0 && i == 0){
                continue;
            }
            if(val * 10 + i > n){
                return;
            }
            res.add(val * 10 + i);
            dfs(res, n, val * 10 + i);
        }
    }
}