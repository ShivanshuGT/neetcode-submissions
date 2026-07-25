class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int val = nums[0];
        int cnt = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] != val){
                cnt -= 1;
                if(cnt == 0){
                    val = nums[i];
                    cnt = 1;
                }
            }else{
                cnt += 1;
            }
        }
        return val;
    }
}