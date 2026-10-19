class Solution {
    public String convertToTitle(int n) {
        if(n == 0){
            return "";
        }
        if(n <= 26){
            return String.valueOf((char)('A' + (n-1)));
        }
        StringBuilder ans = new StringBuilder();
        int x = n / 26;
        int remainder = n % 26;
        ans.append(convertToTitle(x));

        if(remainder > 0){
            ans.append((char)('A' + remainder-1));
        }
        
        return ans.toString();
        
    }
}