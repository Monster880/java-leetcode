class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sumDay = 0;
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while(left < right){
            int mid = (left + right) >> 1;
            int need = 1, cur = 0;
            for(int weight : weights){
                if(cur + weight > mid){
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if(need <= days){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}