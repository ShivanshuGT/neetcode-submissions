class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        int n = s.length();
        int i = 0;

        while(i < n){
            if("]".equals(s.substring(i, i+1))){
                String encodedString = "";
                while(!"[".equals(stack.peek())){
                    encodedString = stack.pop() + encodedString;
                }
                // pops the "]" token
                stack.pop();
                String kstr = new String();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    kstr = stack.pop() + kstr; 
                }
                int k = Integer.valueOf(kstr);
                StringBuilder str = new StringBuilder();
                while(k != 0){
                    str.append(encodedString);
                    k -= 1;
                }
                stack.push(str.toString());
            }else{
                stack.push(s.substring(i, i+1));
            }
            i += 1;
            
        }

        String ans = "";

        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
        
    }
}