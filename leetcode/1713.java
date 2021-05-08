class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> have = new HashMap<>();
        int n = target.length;
        for(int i=0;i<n;i++){
            have.put(target[i],i);
        }
        int length = 0;
        int[] dp = new int[n];
        for(int x: arr){
            if(!have.containsKey(x)){
                continue;
            }
            int y = have.get(x);
            int left = 0, right = length-1;
            while(left <= right){
                int mid = (left+ right) >> 1;
                if(dp[mid] >= y){
                    right = right -1;
                }else{
                    left = left + 1;
                }
            }
            dp[++right] = y;
            if(right == length){
                length++;
            }
        }
        return n - length;
    }
}