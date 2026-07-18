class Solution {
    public double myPow(double x, int n) {

        int m = n;

        n = Math.abs(n);

        double ans = 1;

        while(n > 0){
            if(n % 2 != 0){
                n = n - 1;
                ans *= x;
            }else{
                n = n / 2;
                x = x * x;
            }
        }

        if(m < 0){
            return 1.0/ans;
        }
        return ans;
        
    }
}
