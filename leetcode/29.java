class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            int value = b;
            int k = 1;
            while(value >= 0xc0000000 && a <= value + value){
                value = value + value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return sign == 1 ? res : -res;
    }
}