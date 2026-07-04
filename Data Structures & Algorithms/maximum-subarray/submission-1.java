class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int beg = -1;
        int end = -1;
        int i = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        while(i < n){
            if(sum == 0){
                start = i;
            }
            sum += nums[i];

            if(sum > ans){
                ans = sum;
                beg = start;
                end = i;
            }

            if(sum < 0){
                sum = 0;
            }
            i += 1;
        }
        return ans;
        
    }
}
