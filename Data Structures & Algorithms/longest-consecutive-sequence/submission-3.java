class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        if(n == 0){
            return 0;
        }
        int ans = 1;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i] - 1)){
                int count = map.get(nums[i]-1) + 1;
                ans = Math.max(ans, count);
                map.put(nums[i], count);
            }else{
                map.put(nums[i], 1);
            }
            
        }
        return ans;
        
    }
}
