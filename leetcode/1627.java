class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind ufa = new UnionFind(n);
        for(int i= threshold+1; i*2 <= n; i++){
            for(int j=2; i*j<=n; j++){
                ufa.merge(i, i*j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            ans.add(ufa.getf(query[0]) == ufa.getf(query[1]));
        }
        return ans;
    }
}

class UnionFind{
    int[] f;
    int[] num;
    int n;
    int setCount;
    public UnionFind(int n){
        this.n = n;
        this.setCount = n;
        this.f = new int[n+1];
        this.num = new int[n+1];
        Arrays.fill(num, 1);
        for(int i=1;i<=n;i++){
            f[i]= i;
        }
    }

    public int getf(int x){
        return f[x] == x ? x : (f[x] = getf(f[x]));
    }

    public Boolean merge(int x, int y){
        x = getf(x);
        y = getf(y);
        if(x == y){
            return false;
        }
        if(num[x] > num[y]){
            f[y] = x;
            num[x] += num[y];
        }else{
            f[x] = y;
            num[y] += num[x];
        }
        --setCount;
        return true;
    }
}