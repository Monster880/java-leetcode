class Solution {
    private int[] index;
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        this.index = new int[nums.length];
        this.temp = new int[nums.length];
        this.tempIndex = new int[nums.length];
        this.ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }
        int left = 0, right = nums.length - 1;
        mergeSort(nums, left, right);
        List<Integer> list = new ArrayList<Integer>();
        for( int num : ans){
            list.add(num);
        }
        return list;
    }

    public void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right); 
    }

    public void merge(int[] nums, int left, int mid, int right){
        for(int i=left,j=mid+1,k=left;k<=right;k++){
            if(i <= mid && (j > right || nums[i] <= nums[j])){
                ans[index[i]] += (j - mid - 1);
                temp[k] = nums[i];
                tempIndex[k] = index[i++];
            }else{
                temp[k] = nums[j];
                tempIndex[k] = index[j++];
            }
        }
        for(int i=left;i<=right;i++){
            index[i] = tempIndex[i];
            nums[i] = temp[i];
        }
    }
}