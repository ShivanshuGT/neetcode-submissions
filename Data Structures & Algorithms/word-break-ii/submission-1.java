class Solution {

    private void recursive(String s, int ind, Set<String> set, List<String> ans, 
    List<String> temp){
        int n = s.length();
        int len = 0;
        for(String x : temp){
            len += x.length();
        }
        if(n == len){
            ans.add(temp.stream().collect(Collectors.joining(" ")));
            return;
        }

        for(int i = ind; i < n; i++){
            String x = s.substring(ind, i+1);
            if(set.contains(x)){
                temp.add(x);
                recursive(s, i+1, set, ans, temp);
                temp.removeLast();
                
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Set<String> set = wordDict.stream().collect(Collectors.toSet());
        recursive(s, 0, set, ans, temp);
        return ans;
        
    }
}