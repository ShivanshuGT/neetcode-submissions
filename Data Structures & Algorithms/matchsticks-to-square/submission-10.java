class Solution {

    private boolean recursive(int[] arr, int ind, int[] sides, int max){
        int n = arr.length;
        if(ind >= n){
            return true;
        }

        for(int i = 0; i < 4; i++){
            if((sides[i] + arr[ind]) <= max){
                sides[i] += arr[ind];
                if(recursive(arr, ind+1, sides, max)){
                    return true;
                }
                sides[i] -= arr[ind];
            }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += matchsticks[i];
        }

        if(! (sum % 4 == 0)){
            return false;
        }

        int[] sides = new int[4];
        return recursive(matchsticks, 0, sides, sum/4);
        
    }
}