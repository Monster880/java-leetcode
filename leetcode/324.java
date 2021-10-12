class Solution {
    public static void wiggleSort(int[] nums) {
            int[] bucket = new int[5001];
            int bucketLen = bucket.length - 1;
            int len = nums.length;
            // 桶排序 数组存的值是 该index值的数量
            for (int num : nums) {
                bucket[num]++;
            }
    
            // len为奇数时 小 大 小 大 小
            // len为偶数时 小 大 小 大
            // 定义 biggerIndex 和 smallerIndex 用于索引较大数字和较小数字的index范围
            int biggerIndex;
            int smallerIndex;
    
            if (len % 2 == 1) {
                biggerIndex = len - 2;
                smallerIndex = len - 1;
            } else { // len % 2 == 0
                biggerIndex = len - 1;
                smallerIndex = len - 2;
            }
    
            // 第二个总是较大数
            for (int j = 1; j <= biggerIndex; j += 2) {
                // 先给大的找完再给小的找
                while (bucket[bucketLen] == 0) bucketLen--;
                nums[j] = bucketLen;
                bucket[bucketLen]--;
            }
    
            // 第一个总是较小数
            for (int i = 0; i <= smallerIndex; i += 2) {
                // 大的找完了再给小的找
                while (bucket[bucketLen] == 0) bucketLen--;
                nums[i] = bucketLen;
                bucket[bucketLen]--;
            }
    
            return;
        }
    }