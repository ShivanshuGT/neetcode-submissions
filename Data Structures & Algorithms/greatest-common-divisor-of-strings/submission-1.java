class Solution {

    private String multiplyString(String s, int factor){
        StringBuilder ans = new StringBuilder();

        for(int i = 1; i <= factor; i++){
            ans.append(s);
        }
        return ans.toString();
    }

    private boolean canDivideStrings(String str1, String str2, String x){
        int n1 = str1.length();
        int n2 = str2.length();

        int n = x.length();

        if(n1 % n != 0 || n2 % n != 0){
            return false;
        }

        int f1 = n1 / n;
        int f2 = n2 / n;

        return str1.equals(multiplyString(x, f1)) && str2.equals(multiplyString(x, f2));

        
    }
    public String gcdOfStrings(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        if(n1 < n2){
            return gcdOfStrings(str2, str1);
        }
        
        // assume str2 is smallest
        for(int i = n2; i >= 1; i--){
            if(canDivideStrings(str1, str2, str2.substring(0, i))){
                return str2.substring(0, i);
            }
        }
        return "";
    }
}