class Solution {
    private int getNumberOfOneBits(int x){
        int res = 0;
        while(x != 0){
            x = x & (x-1);
            res += 1;
        }
        return res;
    }
    public int[] countBits(int n) {

        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = getNumberOfOneBits(i);
        }
        return ans;
        
    }
}
