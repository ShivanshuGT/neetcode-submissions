class Solution {

    private static List<List<Integer>> twoSum(int[] nums, int start, int target){
        int n = nums.length;
        int left = start;
        int right = n-1;
        List<List<Integer>> ans = new ArrayList<>();
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                left += 1;
            }else if(sum > target){
                right -= 1;
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(nums[left]);
                l.add(nums[right]);
                ans.add(l);
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;
                left += 1;
                right -= 1;
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= n-3; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            List<List<Integer>> list = twoSum(nums, i+1, target);
            if(!list.isEmpty()){
                for(List<Integer> l : list){
                    l.add(0, nums[i]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}