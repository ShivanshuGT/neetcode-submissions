class Solution {

    private boolean recursive(int[] arr, int[] temp, int ind, int max){
        int n = arr.length;

        if(ind >= n){
            return true;
        }

        int k = temp.length;
        for(int i = 0; i < k; i++){
            if((temp[i] + arr[ind]) <= max){
                temp[i] += arr[ind];
                if(recursive(arr, temp, ind+1, max)){
                    return true;
                }
                temp[i] -= arr[ind];
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if(!(sum % k == 0)){
            return false;
        }

        int max = sum / k;

        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                return false;
            }
        }

        Arrays.sort(nums);

        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        int[] temp = new int[k];
        return recursive(nums, temp, 0, max);
        
    }
}