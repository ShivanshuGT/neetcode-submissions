class Solution {

    private String helper(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();

        while(i < n1 && j < n2){
            if(s1.charAt(i) == s2.charAt(j)){
                ans.append(s1.charAt(i));
            }else{
                return ans.toString();
            }
            i += 1;
            j += 1;
        }
        return ans.toString();
    }
    public String longestCommonPrefix(String[] strs) {

        String ans = strs[0];
        int n = strs.length;

        int i = 1;

        while(i < n){
            ans = helper(ans, strs[i]);
            i += 1;
        }
        return ans;
        
    }
}