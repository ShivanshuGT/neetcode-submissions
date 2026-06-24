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

            String palindrome = s.substring(low+1, high);

            if(palindrome.length() > maxLength){
                maxLength = palindrome.length();
                ans = palindrome;
            }

            // even length palindrome
            low = i-1;
            high = i;

            while(low >= 0 && high < n && (s.charAt(low) == s.charAt(high))){
                low -= 1;
                high += 1;
            }

            palindrome = s.substring(low+1, high);

            if(palindrome.length() > maxLength){
                maxLength = palindrome.length();
                ans = palindrome;
            }

        }

        return ans;
        
    }
}
