class Solution {

    private int recursiveHelper(String text1, String text2, int i, int j, int[][] dp){
        int n = text1.length();
        int m = text2.length();

        if(i >= n || j >= m){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] =  1 + recursiveHelper(text1, text2, i+1, j+1, dp);
        }else{
            dp[i][j] =  Math.max(recursiveHelper(text1, text2, i, j+1, dp) , recursiveHelper(text1, text2, i+1, j, dp));
        }
        return dp[i][j];
    }

    private int recursive(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(text1, text2, 0, 0, dp);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return recursive(text1, text2);
    }
}
