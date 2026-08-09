class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j-1] == nums[j]){
                    continue;
                }

                int left = j+1;
                int right = n-1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(nums[i] > 0 && nums[j] > 0 && nums[left] > 0 && nums[right] > 0 
                        && sum < 0){
                            // overflow case
                            return new ArrayList<>();
                        }

                    if(sum < target){
                        left += 1;
                    }else if(sum > target){
                        right -= 1;
                    }else{
                        List<Integer> quad = List.of(nums[i], nums[j], 
                            nums[left], nums[right]);

                        left += 1;
                        right -= 1;

                        while(left < right && nums[left-1] == nums[left]){
                            left += 1;
                        }

                        while(left < right && nums[right+1] == nums[right]){
                            right -= 1;
                        }
                        ans.add(quad);
                    }
                }
            }
        }
        return ans;
        
    }
}