class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for(int i=0; i<n; i++){
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while(sx <= x){
                sx *= 10;
            }
            while(sy <= y){
                sy *= 10;
            }
            return (int)(-sy * x - y + sx * y + x);
        });
        if(numsArr[0] == 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for(int num : numsArr){
            sb.append(num);
        }
        return sb.toString();
    }
}