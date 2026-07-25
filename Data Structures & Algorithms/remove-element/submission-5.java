class Solution {

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] == val){
                count += 1;
            }
        }

        int left = 0;
        int right = n-1;

        // move all the val elements to the right of the array
        while(right >= 0 && nums[right] == val){
            right -= 1;
        }

        while(left < right){
            if(nums[left] != val){
                left += 1;
                continue;
            }
            if(nums[left] == val && nums[right] != val){
                swap(nums, left, right);
                right -= 1;    
                left += 1;
            }
            while(right >= 0 && nums[right] == val){
                right -= 1;
            }

            // left += 1;
            
        }
        return n - count;
        
    }
}