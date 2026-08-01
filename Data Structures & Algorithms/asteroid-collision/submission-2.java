class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int n = asteroids.length;
        stack.push(asteroids[0]);
        for(int i = 1; i < n; i++){
            boolean canPush = true;

            while(!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0)){
                    // collision will happen
                    if(Math.abs(stack.peek()) > Math.abs(asteroids[i])){
                        canPush = false;
                        break;
                    }else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                        canPush = false;
                        stack.pop();
                        break;
                    }else{
                        stack.pop();
                    }
                
            }
            if(canPush){
                stack.push(asteroids[i]);
            }
            
        }
        int x = stack.size();
        if(x == 0){
            return new int[0];
        }
        int[] ans = new int[x];
        int y = x-1;
        while(y >= 0){
            ans[y] = stack.pop();
            y -= 1;
        }
        return ans;

        
    }
}