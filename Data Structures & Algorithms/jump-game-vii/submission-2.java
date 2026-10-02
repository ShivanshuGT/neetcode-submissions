class Solution {

    private boolean recursive(int idx, String s, int max, int min, int[] dp){
        int n = s.length();

        if(idx == n-1){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1;
        }

        boolean result = false;
        for(int i = max; i >= min; i--){
            if((idx + i < n) && (s.charAt(idx+i) == '0')){
                if(recursive(idx+i, s, max, min, dp)){
                    result = true;
                    break;
                }
            }
        }
        if(result){
            dp[idx] = 1;
        }else{
            dp[idx] = 0;
        }
        return result;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }

        if(s.charAt(n-1) != '0'){
            return false;
        }

        return recursive(0, s, maxJump, minJump, dp);


        
    }
}