class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        int highBits = 0;
        for(int i=1; i<=n;i++){
            if((i & (i-1)) == 0){
                highBits = i;
            }
            bits[i] = bits[i-highBits] + 1;
        }
        return bits;
    }
}