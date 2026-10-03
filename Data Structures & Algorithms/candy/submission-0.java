class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int ans = 1;
        int i = 1;

        while(i < n){
            // if its a falt curve
            if(ratings[i] == ratings[i-1]){
                ans += 1;
                i += 1;
                continue;
            }

            // if its an increasing curve
            int peak = 1;
            while((i < n) && (ratings[i] > ratings[i-1])){
                peak += 1;
                ans += peak;
                i += 1;
            }

            // if its a decreasing curve
            int down = 1;
            while((i < n) && (ratings[i] < ratings[i-1])){
                ans += down;
                down += 1;
                i += 1;
            }

            // adjust the peak
            if(down > peak){
                ans += (down - peak);
            }
        }
        return ans;
        
    }
}