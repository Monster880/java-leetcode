class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int reverseNumber = 0;
        int temp = x;
        while(temp > 0){
            reverseNumber = reverseNumber * 10 + temp % 10;
            temp /= 10;
        }
        return x == reverseNumber;
    }
}