class Solution {
    public int[] sortArray(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        int x = 0;

        for(int i = min; i <= max; i++){
            int freq = map.getOrDefault(i, 0);
            while(freq > 0){
                nums[x] = i;
                x += 1;
                freq -= 1;
            }
        }
        return nums;
        
    }
}