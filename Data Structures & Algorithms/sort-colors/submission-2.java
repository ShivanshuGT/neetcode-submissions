class Solution {

    private void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid += 1;
                low += 1;
            }else if(nums[mid] == 1){
                mid += 1;
            }else{
                swap(nums, mid, high);
                high -= 1;
            }
        }
        
    }
}