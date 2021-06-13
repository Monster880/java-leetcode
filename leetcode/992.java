class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }

    private int atMostKDistinct(int[] nums, int k){
        int n = nums.length;
        int[] freq = new int[n+1];
        int left =0, right = 0;
        int count =0, res=0;
        while(right < n){
            if(freq[nums[right]] == 0){
                count++;
            }
            freq[nums[right]]++;
            right++;

            while(count > k){
                freq[nums[left]]--;
                if(freq[nums[left]] == 0){
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}