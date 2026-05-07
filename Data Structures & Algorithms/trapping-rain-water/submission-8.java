class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int ans = 0;

        while(left < right){
            if(height[left] > leftMax){
                leftMax = height[left];
            }
            if(height[right] > rightMax){
                rightMax = height[right];
            }

            if(height[left] > height[right]){
                ans += Math.min(leftMax, rightMax) - height[right];
                right -= 1;
            }else{
                ans += Math.min(leftMax, rightMax) - height[left];
                left += 1;
            }
        }
        return ans;
        
    }
}
