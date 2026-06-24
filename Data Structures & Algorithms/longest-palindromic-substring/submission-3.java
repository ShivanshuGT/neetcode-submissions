class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1){
            return s;
        }

        int maxLength = Integer.MIN_VALUE;
        String ans = "";

        for(int i = 1; i < n; i++){
            // odd length palindrome
            int low = i;
            int high = i;

            while(low >= 0 && high < n && (s.charAt(low) == s.charAt(high))){
                low -= 1;
                high += 1;
            }

            if((high - low + 1) > maxLength){
                maxLength = high - low + 1;
                ans = s.substring(low+1, high);
            }

            // even length palindrome
            low = i-1;
            high = i;

            while(low >= 0 && high < n && (s.charAt(low) == s.charAt(high))){
                low -= 1;
                high += 1;
            }

            if((high - low + 1) > maxLength){
                maxLength = high - low + 1;
                ans = s.substring(low+1, high);
            }

        }

        return ans;
        
    }
}
