class Solution {

    private void recursive(int[] nums, int ind, int xor, int[] ans){
        int n = nums.length;
        ans[0] = ans[0] + xor;
        for(int i = ind; i < n; i++){
            int temp = xor;
            xor = xor ^ nums[i];
            recursive(nums, i+1, xor, ans);
            xor = temp;
        }
    }
    public int subsetXORSum(int[] nums) {
        int[] ans = new int[1];
        recursive(nums, 0, 0, ans);
        return ans[0];
    }
}