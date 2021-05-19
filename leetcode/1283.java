class Solution {
    private Integer search(int[] nums, int left, int right, int threshold){
        if(left > right){
            return null;
        }
        int mid = (left + right) /2;
        int t = threshold;
        for(int i=0; i<nums.length && t >= 0; t -= (nums[i++] + mid - 1) / mid);
        if(t < 0){
            return search(nums, mid + 1, right, threshold);
        }
        Integer temp = search(nums, left, mid - 1, threshold);
        return temp == null ? mid : temp;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        return search(nums, 1, 1000000, threshold);
    }
}