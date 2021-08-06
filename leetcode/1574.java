class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length < 2){
            return 0;
        }
        int n = arr.length;
        int left = 0;
        while(left < n -1 && arr[left] <= arr[left+1]){
            left++;
        }
        if(left == n-1){
            return 0;
        }
        int right = n -1;
        while(right > 0 && arr[right] >= arr[right-1]){
            right--;
        }
        int res = Math.min((n-1) - (left + 1)+1, right);
        int i = 0;
        int j = right;
        while(i <= left && j <= n-1){
            if(arr[i] <= arr[j]){
                res = Math.min(res, j-i-1);
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}