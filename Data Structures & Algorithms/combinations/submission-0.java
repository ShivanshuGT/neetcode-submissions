class Solution {

    private void recursive(int n, int ind, int k, List<Integer> temp, List<List<Integer>> ans){

        if(temp.size() == k){
            List<Integer> ls = List.copyOf(temp);
            ans.add(ls);
            return;
        }

        for(int i = ind; i <= n; i++){
            temp.add(i);
            recursive(n, i+1, k, temp, ans);
            temp.removeLast();
        }


    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recursive(n, 1, k, temp, ans);
        return ans;
         
        
    }
}