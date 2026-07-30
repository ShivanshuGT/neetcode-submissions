class Solution {
    public int firstMissingPositive(int[] nums) {


        int n = nums.length;
        boolean containsOne = false;

        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                containsOne = true;
            }

            if(nums[i] > n || nums[i] <= 0){
                nums[i] = 1;
            }
        }

        if(!containsOne){
            // since 1 is the smallest positive integer
            return 1;
        }

        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            int idx = num - 1;
            if(nums[idx] < 0){
                continue;
            }else{
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }

        // all numbers from 1 to n were present in the array, hence ans is 'n+1'
        return n+1;
        
    }
}