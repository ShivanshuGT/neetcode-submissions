class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for(String token : tokens){
            if("".equals(token) || ".".equals(token)){
                continue;
            }else if("..".equals(token)){
                if(stack.isEmpty()){
                    continue;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(token);
            }
        }

        String result = "";
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        if("".equals(result)){
            return "/";
        }
        return result;
    }
}