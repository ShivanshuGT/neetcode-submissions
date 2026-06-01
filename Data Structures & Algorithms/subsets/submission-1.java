class Solution {
    

    private void subsetsHelper(int[] nums, int ind, List<List<Integer>> ans, List<Integer> temp){
        int n = nums.length;
        if(ind >= n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        subsetsHelper(nums, ind+1, ans, temp);  
        temp.removeLast();
        subsetsHelper(nums, ind+1, ans, temp);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, 0, ans, temp);
        return ans;

        
    }
}
