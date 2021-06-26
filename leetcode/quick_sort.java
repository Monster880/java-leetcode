Class QuickSort{
    public void main(int[] nums){
        int len = nums.length;
        quickSort(nums, 0, len);
    }

    public void quickSort(int[] nums, int left, int right){
        int position = helperSort(nums, left , right);
        quickSort(nums,left, position-1);
        quickSort(nums, position+1, right);
    }
    private int helperSort(int[] nums, int left, int right){
        int temp=nums[left];
        int i=left,j = right-1;
        while(i < j){
            while(nums[i] <= temp) i++;
            nums[i] = temp;
            while(nums[j] >= temp) j--;
            nums[j] = nums[i];
        }
        return i;
    }
}