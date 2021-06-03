class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1000000;
        while(left <= right){
            int mid = (left + right) >> 1;
            int c = 0;
            for(int i=0, j=0; i< nums.length;i++){
                for(; nums[i] - nums[j] > mid;j++);
                c += i-j;
            }
            if(c >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right + 1;
    }
}