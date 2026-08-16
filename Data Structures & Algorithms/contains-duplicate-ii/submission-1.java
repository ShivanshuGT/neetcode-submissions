class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 1;
        int n = nums.length;

        while(right < n){
            while(right < n && (right - left) <= k){
                if(nums[left] == nums[right]){
                    return true;
                }
                right += 1;
            }
            left += 1;
            right = left + 1;
        }
        return false;
        
    }
}