class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        int n = s.length();
        ans += 1;

        for(int i = 1; i < n; i++){
            int low = i;
            int high = i;

            while(low >= 0 && high < n && (s.charAt(low) == s.charAt(high))){
                low -= 1;
                high += 1;
                ans += 1;

            }

            low = i-1;
            high = i;
            while(low >= 0 && high < n && (s.charAt(low) == s.charAt(high))){
                low -= 1;
                high += 1;
                ans += 1;

            }


        }
        return ans;
        
    }
}
