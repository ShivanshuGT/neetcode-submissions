class Solution {

    private static int findHoursAtMid(int[] piles, int speed){
        int ans = 0;
        for(int x : piles){
            ans += Math.ceil(((double)x/speed));
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        if(h < n){
            return -1;
        }
        int right = Integer.MIN_VALUE;
        for(int  i = 0; i < n; i++){
            if(right < piles[i]){
                right = piles[i];
            }
        }

        int left = 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int hoursAtMid = findHoursAtMid(piles, mid);
            if(hoursAtMid <= h){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
        
    }
}
