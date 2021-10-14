class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > mid) return true;
            if(num <= min) min = num;
            else mid = num;
        }
        return false;
    }
}