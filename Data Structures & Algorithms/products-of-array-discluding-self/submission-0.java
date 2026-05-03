class Solution {
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        Map<Integer, Integer> suffixMap = new HashMap<>();
        int n = nums.length;
        prefixMap.put(0, nums[0]);
        suffixMap.put(n-1, nums[n-1]);
        int prefixProd = nums[0];
        int suffixProd = nums[n-1];
        for(int i = 1;i < n; i++){
            prefixMap.put(i, prefixProd*nums[i]);
            prefixProd *= nums[i];

            suffixMap.put(n-i-1, suffixProd*nums[n-i-1]);
            suffixProd *= nums[n-i-1];
        }

        int[] ans = new int[n];
        ans[0] = suffixMap.get(1);
        ans[n-1] = prefixMap.get(n-2);
        for(int i = 1; i < n-1; i++){
            ans[i] = prefixMap.get(i-1) * suffixMap.get(i+1);
        }
        return ans;
    }
}  
