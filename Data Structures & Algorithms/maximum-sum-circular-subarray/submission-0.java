class Solution {

    private int findMaximumSumSubarray(int[] arr){
        int n = arr.length;
        int max = arr[0];
        int cur = arr[0];

        for(int i = 1; i < n; i++){
            cur = Math.max(arr[i] + cur, arr[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    private int findMinimumSumSubarray(int[] arr){
        int n = arr.length;
        int min = arr[0];
        int cur = arr[0];

        for(int i = 1; i < n; i++){
            cur = Math.min(arr[i] + cur, arr[i]);
            min = Math.min(min, cur);
        }
        return min;
    }
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int max = findMaximumSumSubarray(nums);
        int min = findMinimumSumSubarray(nums);

        if(max > 0){
            return Math.max(max, sum-min);
        }else{
            return max;
        }
        
    }
}