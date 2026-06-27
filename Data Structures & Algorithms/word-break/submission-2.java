class Solution {

    private boolean recursiveHelper(String s, List<String> dict, Map<String, Boolean> map){
        if(s.length () == 0){
            return true;
        }

        if(map.containsKey(s)){
            return map.get(s);
        }
        boolean res = false;
        for(String w : dict){
            if(s.startsWith(w)){
                res = recursiveHelper(s.substring(w.length()), dict, map);
                if(res){
                    map.put(s, res);
                    return res;
                }
            }
        }
        map.put(s, res);
        return res;
    }

    private boolean recursive(String s, List<String> dict){
        Map<String, Boolean> map = new HashMap<>();
        return recursiveHelper(s, dict, map);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return recursive(s, wordDict);
    }
}
