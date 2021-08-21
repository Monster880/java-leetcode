class Solution {
    public int findKthLargest(int[] nums, int k) {
        findK(nums,0,nums.length - 1,nums.length - k);
        return nums[nums.length - k];
    }
    private int findK(int[] nums,int left,int right,int k){
        int position = partition(nums,left,right);
        if(position == k) return position;
        return k > position ? findK(nums,position + 1,right,k) : findK(nums,left,position - 1,k);
    }

    private int partition(int[] nums,int l,int r){
        int left = l, right = r;
        if(left == right) return left;
        swap(nums,left,left + 1 + new Random().nextInt(right - left)); 
        int temp = nums[left];
        while(left < right){
            while(left < right && temp <= nums[right]){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && temp >= nums[left]){
                left++;
            }
            nums[right] = nums[left];            
        }
        nums[left] = temp;
        return left;
    }

    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}