class Solution {
    public int reverse(int x) {

        int res = 0;

        while(x != 0){
            int digit = x % 10;
            x = x / 10;

            // handle positive overflow
            if((res > Integer.MAX_VALUE / 10) || ((res == Integer.MAX_VALUE / 10) && (digit >= Integer.MAX_VALUE % 10))){
                return 0;
            }

            // handle negative overflow
            if((res < Integer.MIN_VALUE / 10) || ((res == Integer.MIN_VALUE / 10) && (digit <= Integer.MIN_VALUE % 10))){
                return 0;
            }

            res = res * 10 + digit;

        }

        return res;
        
    }
}
