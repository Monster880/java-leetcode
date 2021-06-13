class Solution {
    public int preimageSizeFZF(long k) {
        long left = k, right = 10*k+1;
        while(left < right){
            long mid = (left + right) >> 1;
            long sum = count(mid);
            if(sum == k) return 5;
            else if(sum < k) left = mid + 1;
            else right = mid;
        }
        return 0;
    }

    public long count(long x){
        if(x == 0) return 0;
        return x/5 + count(x/5);
    }
}