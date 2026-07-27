class Solution {
    public void sortColors(int[] nums) {

        int ones = 0;
        int zeroes = 0;
        int twos = 0;

        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zeroes += 1;
            }else if(nums[i] == 1){
                ones += 1;
            }else{
                twos += 1;
            }
        }

        int x = 0;

        while(zeroes > 0){
            nums[x] = 0;
            zeroes -= 1;
            x += 1;
        }

        while(ones > 0){
            nums[x] = 1;
            ones -= 1;
            x += 1;
        }

        while(twos > 0){
            nums[x] = 2;
            twos -= 1;
            x += 1;
        }
        
    }
}