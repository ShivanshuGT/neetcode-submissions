class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int n = triplets.length;

        int first = target[0];
        int[] ans = {-1, -1, -1};

        for(int i = 0; i < n; i++){
            int[] x = triplets[i];
            if((target[0] == x[0] && target[1] >= x[1] && target[2] >= x[2])
            || (target[1] == x[1] && target[0] >= x[0] && target[2] >= x[2])
            || (target[2] == x[2] && target[0] >= x[0] && target[1] >= x[1])){
                ans[0] = Math.max(ans[0], x[0]);
                ans[1] = Math.max(ans[1], x[1]);
                ans[2] = Math.max(ans[2], x[2]);
            }
            if(ans[0] == target[0] && ans[1] == target[1] && ans[2] == target[2]){
                return true;
            }

        }

        if(ans[0] == target[0] && ans[1] == target[1] && ans[2] == target[2]){
            return true;
        }
        return false;
        
    }
}
