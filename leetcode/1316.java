class Solution {
    private static final int M = 1000000007;
    private static final int W = 131;
    private int[] h,w;

    private int add(int x, int y){
        if((x += y) >= M){
            x -= M;
        }
        return x;
    }

    private int sub(int x,int y){
        if((x -= y) < 0){
            x += M;
        }
        return x;
    }

    private int mul(long x, long y){
        return (int)(x * y % M);
    }

    private int get(int from, int to){
        return from == 0 ? h[to] : sub(h[to], h[from-1]);
    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        w = new int[n];
        h = new int[n];
        for(int i=0; i<n;i++){
            if(i == 0){
                w[0] = 1;
            }else{
                w[i] = mul(w[i-1], W);
                h[i] = h[i-1];
            }
            h[i] = add(h[i], mul(w[i], text.charAt(i)));
        }
        int r = 0;
        int[] a = new int[n];
        for(int len = 1; len + len <= n; len++){
            Set<Integer> s = new HashSet<>();
            for(int i=0; i+len <= n; i++){
                a[i] = mul(get(i, i+len-1),w[n-i-1]);
                if(i >= len && a[i] == a[i-len]){
                    s.add(a[i]);
                }
            }
            r += s.size();
        }
        return r;
    }
}