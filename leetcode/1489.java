class Solution {
    private static final int INF = 1234567890;
    private int[] f, num;
    private int[][] e;

    private void init(int n){
        f = new int[n];
        num = new int[n];
        for(int i=0; i<n;i++){
            f[i] = i;
            num[i] = 1;
        }
    }

    private int getf(int x){
        return f[x] == x ? x : (f[x] = getf(f[x]));
    }

    private boolean merge(int x, int y){
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
         return true;
    }

    private int mst(int n, int ind){
        int r=0, m=0;
        for(int i=0; m<n-1 && i<e.length;i++){
            if(i == ind){
                continue;
            }
            if(merge(e[i][0], e[i][1])){
                m++;
                r += e[i][2];
            }
        }
        return m == n-1 ? r : INF;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        init(n);
        e = new int[edges.length][4];
        for(int i=0;i<e.length;i++){
            for(int j=0;j<3;j++){
                e[i][j] = edges[i][j];
            }
            e[i][3] = i;
        }
        Arrays.sort(e, (a,b) -> (a[2] - b[2]));
        int w = mst(n, -1);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i=0;i<e.length;i++){
            init(n);
            if(mst(n, i) > w){
                a.add(e[i][3]);
            }else{
                init(n);
                merge(e[i][0], e[i][1]);
                if(mst(n -1, i) + e[i][2] == w){
                    b.add(e[i][3]);
                }
            }
        }
        return Arrays.asList(a,b);
    }
}