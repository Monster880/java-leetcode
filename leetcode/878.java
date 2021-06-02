class Solution {
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }

    public int nthMagicalNumber(int n, int a, int b) {
        int m = lcm(a, b);
        long left = 1, right = ((long) n) * a;
        while(left <= right){
            long mid = (left + right) >> 1;
            if(mid / a + mid / b - mid / m >= n){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return (int)((right + 1) % 1000000007);
    }
}