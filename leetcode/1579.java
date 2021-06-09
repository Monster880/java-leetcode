class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        int ans = 0;

        for(int[] edge : edges){
            --edge[1];
            --edge[2];
        }

        for(int[] edge : edges){
            if(edge[0] == 3){
                if(!ufa.merge(edge[1], edge[2])){
                    ++ans;
                }else{
                    ufb.merge(edge[1], edge[2]);
                }
            }
        }

        for(int[] edge : edges){
            if(edge[0] == 1){
                if(!ufa.merge(edge[1], edge[2])){
                    ++ans;
                }
            }else if(edge[0] == 2){
                if(!ufb.merge(edge[1], edge[2])){
                    ++ans;
                }
            }
        }
        if(ufa.setCount != 1 || ufb.setCount != 1){
            return -1;
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
        this.f = new int[n];
        this.num = new int[n];
        Arrays.fill(num,1);
        for(int i=0;i<n;i++){
            f[i] = i;
        }
    }

    public int getf(int x){
        return f[x] == x ? x : (f[x] = getf(f[x]));
    }

    public boolean merge(int x,int y){
        x = getf(x);
        y = getf(y);
        if(x == y){
            return false;
        }
        if(num[x] > num[y]){
            f[y]=x;
            num[x] += num[y];
        }else{
            f[x]=y;
            num[y] += num[x];
        }
        --setCount;
        return true;
    }
}