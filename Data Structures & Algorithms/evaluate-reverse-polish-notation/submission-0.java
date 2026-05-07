class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)){
                int op2 = stack.pop();
                int op1 = stack.pop();
                if("+".equals(str)){
                    stack.push(op1 + op2);
                }else if("-".equals(str)){  
                    stack.push(op1 - op2);
                }else if("*".equals(str)){
                    stack.push(op1 * op2);
                }else{
                    stack.push((int) (op1 / op2));
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
        
    }
}
