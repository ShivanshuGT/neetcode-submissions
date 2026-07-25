class Solution {

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] == val){
                ans += 1;
            }
        }

        int left = 0;
        int right = n-1;
        while(right >= 0 && nums[right] == val){
            right -= 1;
        }

        while(left < right){
            if(nums[left] == val && nums[right] != val){
                swap(nums, left, right);
                right -= 1;
                
            }
            while(right >= 0 && nums[right] == val){
                right -= 1;
            }

            left += 1;
            
        }
        return n - ans;
        
    }
}