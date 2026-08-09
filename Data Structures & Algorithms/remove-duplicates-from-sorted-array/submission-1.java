class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int start = 0;
        int x = 0;

        while(start < n){
            int temp = start;
            while(temp < n && nums[start] == nums[temp]){
                temp += 1;
            }
            nums[x] = nums[start];
            x += 1;
            start = temp;
        }
        return x;
        
    }
}