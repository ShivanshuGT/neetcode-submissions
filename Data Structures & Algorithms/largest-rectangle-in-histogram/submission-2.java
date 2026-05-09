class Solution {

    private static int[] nsi(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        ans[n-1] = n;
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && (heights[stack.peek()] >= heights[i])){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;

    }

    private static int[] psi(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && (heights[stack.peek()] >= heights[i])){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;

    }
    
    public int largestRectangleArea(int[] heights) {
        int[] psi = psi(heights);
        int[] nsi = nsi(heights);
        int n = heights.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (nsi[i] - psi[i] -1) * heights[i]);
        }
        return ans;
    }
}
