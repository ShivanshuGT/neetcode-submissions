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

        int[] sorted = Arrays.stream(nums)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();
        int[] temp = new int[k];
        return recursive(sorted, temp, 0, max);
        
    }
}