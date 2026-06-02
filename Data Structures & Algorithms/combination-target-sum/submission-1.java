class Solution {

    
    private void helper(int[] nums, int ind, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
        }

        if(target < 0){
            return;
        }

        int n = nums.length;
        for(int i = ind; i< n; i++){
            temp.add(nums[i]);
            helper(nums, i, target - nums[i], ans, temp);
            temp.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, target, ans, temp);
        return ans;
        
    }
}
