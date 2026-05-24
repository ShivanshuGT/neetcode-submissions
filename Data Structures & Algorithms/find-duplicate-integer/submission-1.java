class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0];
        int freq  = 1;
        for(int i = 1; i< n; i++){
            if(ans != nums[i] && freq == 1){
                ans = nums[i];
            }else{
                freq += 1;
            }
        }
        return ans;
    }
}
