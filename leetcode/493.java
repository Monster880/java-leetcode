class Solution {
    private int count(int[] nums, int left, int right){
        if(right - left <= 0){
            return 0;
        }
        int mid = (left + right) >> 1;
        int r = count(nums, left, mid) + count(nums, mid+1, right);
        int[] temp = new int[right - left + 1];
        for(int i=left,j=mid+1,k=0,t=j;k<temp.length;k++){
            if(i<=mid && (j>right || nums[i] < nums[j])){
                for(;t <= right && nums[i] > 2L * nums[t]; t++);
                r += t - mid - 1;
                temp[k] = nums[i++];
            }else{
                temp[k] = nums[j++];
            }
        }
        for(int i=left; i<=right;i++){
            nums[i] = temp[i-left];
        }
        return r;
    }

    public int reversePairs(int[] nums) {
        return count(nums, 0, nums.length-1);
    }
}