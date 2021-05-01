class Solution {
    private double pow(double x, long m){
        double r = 1;
        for(;m>0;m >>= 1){
            if((m&1) == 1){
                r *= x;
            }
            x *= x;
        }
        return r;
    }

    public double myPow(double x, int n) {
        long m = n;
        return m >= 0 ? pow(x,m) : 1./pow(x,-m);
    }
}