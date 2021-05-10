class Solution {
    public int balancedStringSplit(String s) {
        int d = 0, r =0;
        for(char c : s.toCharArray()){
            d += (c == 'R' ? (-1) : 1);
            if(d == 0){
                r++;
            }
        }
        return r;
    }
}