class Solution {

    private static int recursive(String s, int ind, Set<String> d, int[] dp){
        int n = s.length();

        if(ind >= n){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int ans = Integer.MAX_VALUE;

        for(int i = ind; i < n; i++){
            String str = s.substring(ind, i+1);
            int val = 0;
            if(d.contains(str)){
                val += 0;
            }else{
                val += str.length();
            }
            ans = Math.min(ans, val + recursive(s, i+1, d, dp));
        }
        dp[ind] = ans;
        return ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> d = new HashSet<>();
        for(String x : dictionary){
            d.add(x);
        }
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        return recursive(s, 0, d, dp);
    }
}