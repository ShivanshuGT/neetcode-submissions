class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)){
                ans += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
        
    }
}