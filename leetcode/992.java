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
            // 左边界固定前提下，根据右边界最右的下标，计算出来的子区间的个数就是整个函数要返回的值。用右边界固定的前提下，左边界最左边的下标去计算也是完全可以的。
            res += right - left;
        }
        return res;
    }
}