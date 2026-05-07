class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] nextGreatest = new int[n];
        int[] prevGreatest = new int[n];

        int greatest = height[n-1];
        nextGreatest[n-1] = -1;
        for(int i = n-2; i >= 0; i--){
            if(height[i] > greatest){
                nextGreatest[i] = -1;
                greatest = height[i];
            }else{
                nextGreatest[i] = greatest;
            }
        }

        greatest = height[0];
        prevGreatest[0] = -1;
        for(int i = 1; i < n; i++){
            if(height[i] > greatest){
                prevGreatest[i] = -1;
                greatest = height[i];
            }else{
                prevGreatest[i] = greatest;
            }
        }


        int ans = 0;
        for(int i = 0; i < n; i++){
            int val = Math.min(prevGreatest[i], nextGreatest[i]);
            if(val > 0){
                ans += (val - height[i]);
            }
        }
        return ans;
    }
}
