class Solution {
    private boolean isPalindrome(String s){
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left +=1 ;
            right -= 1;
        }
        return true;
    }

    private void helper(String s, List<String> ls, List<List<String>> ans){
        int n = s.length();
        if(s.isEmpty()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 1; i <= n; i++){
            String str = s.substring(0, i);
            if(isPalindrome(str)){
                ls.add(str);
                helper(s.substring(i), ls, ans);
                ls.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        helper(s, ls, ans);
        return ans;
        
    }
}
