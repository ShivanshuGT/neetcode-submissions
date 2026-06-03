class Solution {
    

    private void helper(int[] nums, int ind, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));

        int n = nums.length;
        for(int i = ind; i< n; i++){
            temp.add(nums[i]);
            helper(nums, i+1, ans, temp);
            temp.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, ans, temp);
        return ans;

        
    }
}
