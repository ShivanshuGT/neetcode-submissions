class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left < right){
            ans = Math.max(ans, (right - left) * Math.min(heights[left], heights[right]));
            if(heights[left] < heights[right]){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return ans;
    }
}
