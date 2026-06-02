class Solution {

    private void helper(int[] nums, int ind, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }  
        if(target < 0){
            return;
        }

        int n = nums.length;
        for(int i = ind; i < n; i++){
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(nums, i+1, target-nums[i], ans, temp);
            temp.removeLast();
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, ans, temp);
        return ans;
        
    }
}
