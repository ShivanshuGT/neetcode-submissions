class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        if(s.charAt(n-1) != '0'){
            return false;
        }
        int[] arr = new int[n];
        arr[0] = 1;

        int count = 0;
        for(int i = 1; i < n; i++){
            if(i - minJump >= 0){
                count += arr[i-minJump];
            }

            if(i - maxJump - 1 >= 0){
                count -= arr[i-maxJump-1];
            }

            if(count > 0 && s.charAt(i) == '0'){
                arr[i] = 1;
            }
        }
        return arr[n-1] > 0;
    }
}