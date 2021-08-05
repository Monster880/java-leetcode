class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        else if(new StringBuffer(s).reverse().toString().equals(s)) return 1;
        else return 2;
    }
}