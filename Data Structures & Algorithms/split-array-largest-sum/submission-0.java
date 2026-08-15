class Solution {
    private static int findSubarraysWithMaxCapacityAsMid(int[] nums, int maxCap){
        int ans = 0;
        int i = 0;
        int n = nums.length;

        while(i < n){
            int leftCap = maxCap;
            while(i < n && nums[i] <= leftCap){
                leftCap -= nums[i];
                i += 1;
            }
            ans += 1;
        }
        return ans;
    }
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > left){
                left = nums[i];
            }
            right += nums[i];
        }
        int ans = left;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int subArrays = findSubarraysWithMaxCapacityAsMid(nums, mid);

            if(subArrays == k){
                ans = mid;
                right = mid - 1;
            }else if(subArrays < k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}