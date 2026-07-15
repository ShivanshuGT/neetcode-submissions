class Solution {

    private boolean recursiveHelper(String s, String p, int ind1, int ind2, int[][] dp){
        int n = s.length();
        int m = p.length();

        if(ind1 == n && ind2 == m){
            return true;
        }

        if(ind1 == n){
            return "*".equals(p.substring(ind2+1));
        }

        if(ind2 == m){
            return false;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2] == 1;
        }

        if(ind2+1 < m && p.charAt(ind2+1) == '*'){
            char ch = p.charAt(ind2);
            if(ch == '.'){
                dp[ind1][ind2] =  recursiveHelper(s, p, ind1+1, ind2, dp) || recursiveHelper(s, p, ind1+1, ind2+2, dp) ? 1 : 0;
                return dp[ind1][ind2] == 1;
            }else{
                if(ch == s.charAt(ind1)){
                    dp[ind1][ind2] =  recursiveHelper(s, p, ind1+1, ind2, dp) || recursiveHelper(s, p, ind1+1, ind2+2, dp)
                        || recursiveHelper(s, p, ind1, ind2+2, dp) ? 1: 0;
                    return dp[ind1][ind2] == 1;
                }else{
                    dp[ind1][ind2] =  recursiveHelper(s, p, ind1, ind2+2, dp) ? 1 : 0;
                    return dp[ind1][ind2] == 1;
                }
            }
        }

        if(s.charAt(ind1) == p.charAt(ind2) || p.charAt(ind2) == '.'){
            dp[ind1][ind2] = recursiveHelper(s, p, ind1+1, ind2+1, dp) ? 1 : 0;
            return dp[ind1][ind2] == 1;
        }


        dp[ind1][ind2] = 0;
        return dp[ind1][ind2] == 1;
    }

    private boolean recursive(String s, String p){
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(s, p, 0, 0, dp);
    }
    public boolean isMatch(String s, String p) {
        return recursive(s, p);
        
    }
}
