class Solution {
    public int preimageSizeFZF(long k) {
        long lo = k, hi = 10*k+1;
        while(lo < hi){
            long mi = lo + (hi-lo)/2;
            long zmi = zeta(mi);
            if(zmi == k) return 5;
            else if(zmi < k) lo = mi + 1;
            else hi = mi;
        }
        return 0;
    }

    public long zeta(long x){
        if(x == 0) return 0;
        return x/5 + zeta(x/5);
    }
}