class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] prefix = new int[arr.length + 1];
        for(int i=1;i<=arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int ans= 0, diff = target;
        for(int i=1;i<=arr[arr.length-1]; i++){
            int index = Arrays.binarySearch(arr, i);
            if(index < 0){
                index = -index -1;
            }
            int cur = prefix[index] + (arr.length-index) * i;
            if(Math.abs(target - cur) < diff){
                ans = i;
                diff = Math.abs(target - cur);
            }
        }
        return ans;
    }
}