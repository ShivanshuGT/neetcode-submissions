class Solution {

    private int getSquaredSumOfDigits(int x){
        int ans = 0;

        while(x != 0){
            int digit = x % 10;
            x = x / 10;
            ans += digit*digit;
        }
        return ans;
    }
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while(true){
            int x = getSquaredSumOfDigits(n);
            if(x == 1){
                return true;
            }
            if(set.contains(x)){
                return false;
            }
            set.add(x);
            n = x;
        }

        
    }
}
