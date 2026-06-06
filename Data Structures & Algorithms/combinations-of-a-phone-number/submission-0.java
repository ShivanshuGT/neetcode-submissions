class Solution {

    private Map<Character, List<String>> map = 
    Map.of('2', List.of("a", "b", "c"),
        '3', List.of("d", "e", "f"), 
        '4', List.of("g", "h", "i"),
        '5', List.of("j", "k", "l"),
        '6', List.of("m", "n", "o"),
        '7', List.of("p", "q", "r", "s"),
        '8', List.of("t", "u", "v"),
        '9', List.of("w", "x", "y", "z"));

    private void helper(int ind, String digits, StringBuilder temp, List<String> ans){
        int n = digits.length();
        if(ind >= n){
            ans.add(temp.toString());
            return;
        }

        List<String> options = this.map.get(digits.charAt(ind));
        for(String x : options){
            temp.append(x);
            helper(ind+1, digits, temp, ans);
            temp.setLength(temp.length() - 1);
        }
    
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        if(digits.isEmpty()){
            return ans;
        }
        helper(0, digits, temp, ans);
        return ans;
    }
}
