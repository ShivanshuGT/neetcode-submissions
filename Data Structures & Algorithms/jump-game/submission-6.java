class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int maxTouchedIndex = 0;

        for(int i = 0; i < n; i++){
            if(i > maxTouchedIndex){
                // no previous index was able to touch this index
                return false;
            }

            maxTouchedIndex = Math.max(maxTouchedIndex, i + nums[i]);
            if(maxTouchedIndex >= n-1){
                return true;
            }
        }
        return true;
        
    }
}
