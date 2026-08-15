/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private static int binarySearch(MountainArray arr, int beg, int end, int target){
        while(beg <= end){
            int mid = (beg + end) / 2;
            int val = arr.get(mid);

            if(val == target){
                return mid;
            }else if(val > target){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRev(MountainArray arr, int beg, int end, int target){
        while(beg <= end){
            int mid = (beg + end) / 2;
            int val = arr.get(mid);

            if(val == target){
                return mid;
            }else if(val > target){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int arrLen = mountainArr.length();
        int right = arrLen - 1;
        int peak = -1;

        while(left <= right){
            int mid = (left + right)/2;
            int cur = mountainArr.get(mid);
            int pre = (mid - 1 < 0) ? -1 : mountainArr.get(mid-1);
            int post = (mid + 1 > arrLen - 1) ? -1 : mountainArr.get(mid+1);
            if(pre < cur && cur > post){
                peak = mid;
                break;
            }else if(pre < cur && cur < post){
                // left side of the curve
                left = mid + 1;
            }else{
                // right side of the curve
                right = mid - 1;
            }
        }

        System.out.print("peak index = " + peak);

        int peakValue = mountainArr.get(peak);
        if(target > peakValue){
            return -1;
        }

        if(target == peakValue){
            return peak;
        }

        int leftAns = binarySearch(mountainArr, 0, peak-1, target);
        if(leftAns == -1){
            return binarySearchRev(mountainArr, peak+1, arrLen - 1,
                target);
        }
        return leftAns;
        
    }
}