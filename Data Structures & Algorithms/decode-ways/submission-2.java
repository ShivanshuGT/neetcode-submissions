class Solution {

    private static Map<String, Character> map = new HashMap<>();

    static{
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf(i+1), (char)('A' + i));
        }
    }

    private static boolean isValid(String s){    
        return map.containsKey(s);
    }

    private int helper(String s, int ind, int[] dp){
        int n = s.length();

        if(ind >= n){
            return 1;
        }

        if(s.charAt(ind) == '0'){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int ans = 0;

        for(int i = 1; ind + i <= n; i++){
            String str = s.substring(ind, ind + i);
            if(isValid(str)){
                ans += 1 * helper(s, ind + i, dp);
            }
        }
        dp[ind] = ans;
        return dp[ind];

    }
    

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        
        return helper(s, 0, dp);




        
    }
}
