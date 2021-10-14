class Solution {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        int bucketLen = bucket.length - 1;
        int len = nums.length;
        for(int num : nums){
            bucket[num]++;
        }
        int biggerIndex;
        int smallerIndex;
        if(len % 2 == 1){
            biggerIndex = len - 2;
            smallerIndex = len - 1;
        }else{
            biggerIndex = len - 1;
            smallerIndex = len - 2;
        }
        for(int i=1; i<= biggerIndex; i+=2){
            while(bucket[bucketLen] == 0) bucketLen--;
            nums[i] = bucketLen;
            bucket[bucketLen]--;
        }
        for(int i=0; i <= smallerIndex; i+=2){
            while(bucket[bucketLen] == 0) bucketLen--;
            nums[i] = bucketLen;
            bucket[bucketLen]--;
        }
        return;
    }
}