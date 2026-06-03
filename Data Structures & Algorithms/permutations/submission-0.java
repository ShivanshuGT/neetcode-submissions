class Solution {

    private void swap(int i1, int i2, int[] arr){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private void solve(int ind, int[] nums, List<List<Integer>> ans){
        int n = nums.length;
        if(ind >= n){
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for(int i = ind; i< n; i++){
            swap(i, ind, nums);
            solve(ind+1, nums, ans);
            swap(i, ind, nums);
        }

    }

    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
        
    }
}
