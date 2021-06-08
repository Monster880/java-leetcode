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
                if(!ufa.unite(edge[1], edge[2])){
                    ans++;
                }else{
                    ufb.unite(edge[1], edge[2]);
                }
            }
        }

        for(int[] edge : edges){
            if(edge[0] == 1){
                if(!ufa.unite(edge[1], edge[2])){
                    ++ans;
                }
            }else if(edge[0] == 2){
                if(!ufb.unite(edge[1], edge[2])){
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
    int[] parent;
    int[] size;
    int n;
    int setCount;

    public UnionFind(int n){
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int findset(int x){
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y){
        x = findset(x);
        y = findset(y);
        if(x == y){
            return false;
        }
        if(size[x] < size[y]){
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y){
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}