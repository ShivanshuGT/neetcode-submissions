class Solution {

    private boolean possibilityCheck(int[] weights, int cap, int days){
        int n = weights.length;
        int x = 1;
        int available = cap;
        int i = 0;

        while(i < n){
            if(weights[i] > cap){
                return false;
            }
            if(weights[i] <= available){
                available -= weights[i];
                i += 1;
            }else{
                x += 1;
                available = cap;
            }
        }
        return x <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        // binary search on capacities
        int n = weights.length;

        int right = 0;
        for(int i = 0; i < n; i++){
            right += weights[i];
        }
        int left = 1;

        int ans = right;
        while(left <= right){
            int mid = (left + right) / 2;
            if(possibilityCheck(weights, mid, days)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
        
    }
}