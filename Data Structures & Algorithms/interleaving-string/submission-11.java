class Solution {

    private boolean recursiveHelper(String s1, String s2, String s3, int ind1, int ind2, int ind3, int[][] dp){
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(ind1 == l1 && ind2 == l2 && ind3 == l3){
            return true;
        }

        if(ind3 >= l3){
            return false;
        }

        if(ind1 == l1){
            return s3.substring(ind3).equals(s2.substring(ind2));
        }

        if(ind2 == l2){
            return s3.substring(ind3).equals(s1.substring(ind1));
        }

        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2] == 1;
        }

        boolean result = false;
        // System.out.println(ind1);
        if(s1.charAt(ind1) == s3.charAt(ind3)){
            result = recursiveHelper(s1, s2, s3, ind1+1, ind2, ind3+1, dp);
        }

        if(result){
            return result;
        }

        if(s2.charAt(ind2) == s3.charAt(ind3)){
            result = recursiveHelper(s1, s2, s3, ind1, ind2+1, ind3+1, dp);
        }
        dp[ind1][ind2] = result ? 1 : 0;
        return result;

    }

    private boolean recursive(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(s1, s2, s3, 0, 0, 0, dp);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        return recursive(s1, s2, s3);
    }
}
