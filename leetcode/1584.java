class Solution {
    private int f[], num[];

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

    public int minCostConnectPoints(int[][] points) {
        int n= points.length;
        f = new int[n];
        num = new int[n];
        List<int[]> e = new ArrayList<>();
        for(int i=0;i<n;i++){
            f[i]= i;
            num[i] = 1;
            for(int j=0;j<i;j++){
                e.add(new int[]{i,j,Math.abs(points[i][0] - points[j][0])+Math.abs(points[i][1] - points[j][1])});
            }
        }
        Collections.sort(e,(a,b) -> (a[2] - b[2]));
        int r =0;
        for(int i=0,j=0;i<e.size() && j<n-1;i++){
            int[] p = e.get(i);
            if(merge(p[0],p[1])){
                j++;
                r += p[2];
            }
        }
        return r;
    }
}