class Solution {

    private void helper(int[] nums, int ind, int sum, int target, List<List<Integer>> ans, List<Integer> temp){
        int n = nums.length;
        if(sum > target || ind >= n){
            return;
        }

        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        sum += nums[ind];
        temp.add(nums[ind]);
        helper(nums, ind, sum, target, ans, temp);
        sum -= nums[ind];
        temp.removeLast();
        helper(nums, ind+1, sum, target, ans, temp);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, 0, target, ans, temp);
        return ans;
        
    }
}
