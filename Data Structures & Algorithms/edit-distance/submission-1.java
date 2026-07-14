class Solution {

    private int recursiveHelper(String word1, String word2, int ind1, int ind2, int[][] dp){
        int n = word1.length();
        int m = word2.length();

        if(ind2 == m){
            return n - ind1;
        }

        if(ind1 == n){
            return m - ind2;
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(word1.charAt(ind1) == word2.charAt(ind2)){
            dp[ind1][ind2] =  recursiveHelper(word1, word2, ind1+1, ind2+1, dp);
            return dp[ind1][ind2];
        }
        int insert = 1 + recursiveHelper(word1, word2, ind1, ind2+1, dp);
        int replace = 1 + recursiveHelper(word1, word2, ind1 + 1, ind2+1, dp);
        int delete = 1 + recursiveHelper(word1, word2, ind1+1, ind2, dp);

        dp[ind1][ind2] =  Math.min(insert, Math.min(replace, delete));
        return dp[ind1][ind2];
    }

    private int recursive(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(word1, word2, 0, 0, dp);
    }
    public int minDistance(String word1, String word2) {
        return recursive(word1, word2);
    }
}
