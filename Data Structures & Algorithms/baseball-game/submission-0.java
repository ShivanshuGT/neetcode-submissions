class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String op : operations){
            if("+".equals(op)){
                int top = stack.pop();
                int second = stack.peek();
                stack.push(top);
                stack.push(top + second);
            }else if("C".equals(op)){
                stack.pop();
            }else if("D".equals(op)){
                stack.push(2*stack.peek());
            }else{
                stack.push(Integer.valueOf(op));
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
        
    }
}