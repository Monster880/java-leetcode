class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i : nums){
            if(i > mid) return true;
            if(i <= min) min = i;
            else mid = i;
        }

        return false;
    }
}