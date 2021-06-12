/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int peak = left;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if(index != -1){
            return index;
        }
        return binarySearch(mountainArr, target, peak+1, mountainArr.length()-1, false);
    }

    public int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean flag){
        if(!flag){
            target *= -1;
        }
        while(left <= right){
            int mid = (left + right) >> 1;
            int cur = mountainArr.get(mid) * (flag ? 1 : -1);
            if(cur == target){
                return mid;
            }else if(cur < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}