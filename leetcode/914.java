class Solution {
    private int gcd(int x, int y){
        return y > 0 ? gcd(y, x%y) : x;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] num= new int[10004];
        for(int x:deck){
            num[x]++;
        }
        int g = 0;
        for(int x: num){
            g = gcd(g, x);
            if(g == 1){
                return false;
            }
        }
        return true;
    }
}