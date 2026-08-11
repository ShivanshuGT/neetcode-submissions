class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 0;
        int right = x;
        int ans = 0;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            long prod = (long) mid * mid;
            if(prod == x){
                return mid;
            }else if(prod < x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;

        
    }
}