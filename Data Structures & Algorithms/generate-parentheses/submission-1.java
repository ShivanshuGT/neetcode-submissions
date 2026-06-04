class Solution {

    private void helper(int start, int end, List<String> ans, StringBuilder temp){
        if(start == 0 && end == 0){
            ans.add(temp.toString());
            return;
        }

        if(start > end){
            return;
        }

        if(start > 0){
            temp.append("(");
            helper(start-1, end, ans, temp);
            temp.setLength(temp.length() -1);
        }

        temp.append(")");
            helper(start, end-1, ans, temp);
            temp.setLength(temp.length() -1);
        
        

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append("(");
        helper(n-1, n, ans, temp);
        return ans;

        
    }
}
