class Solution {

    private int recursiveHelper(int[] nums, int ind, int target, int sum){
        int n = nums.length;

        if(ind == n){
            return target == sum ? 1 : 0;
        }

        

        int add = recursiveHelper(nums, ind+1, target, sum + nums[ind]);
        int subtract = recursiveHelper(nums, ind+1, target, sum - nums[ind]);
        return add + subtract;
    }

    private int recursive(int[] nums, int target){
        return recursiveHelper(nums, 0, target, 0);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recursive(nums, target);
    }
}
