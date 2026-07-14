class Solution {

    private int recursiveHelper(String s, String t, int ind1, int ind2, int[][] dp){
        int n = s.length();
        int m = t.length();

        if(ind2 == m){
            return 1;
        }

        if(ind1 == n){
            return 0;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)){
            dp[ind1][ind2] =  recursiveHelper(s, t, ind1+1, ind2+1, dp) + recursiveHelper(s, t, ind1+1, ind2, dp);
        }else{
            dp[ind1][ind2] =  recursiveHelper(s, t, ind1+1, ind2, dp);
        }
        return dp[ind1][ind2];
    }

    private int recursive(String s, String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(s, t, 0, 0, dp);
    }
    public int numDistinct(String s, String t) {
        return recursive(s, t);
        
    }
}
