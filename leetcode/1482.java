class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length / k < m){
            return -1;
        }
        int left =0, right = 1000000000;
        while(left <= right){
            int mid = (left + right) >> 1, remain = m;
            for(int i=0, num=0; remain > 0 && i < bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    if(++num == k){
                        num = 0;
                        --remain;
                    }
                }else{
                    num = 0;
                }
            }
            if(remain == 0){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right + 1;
    }
}