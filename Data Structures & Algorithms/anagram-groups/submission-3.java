class Solution {

    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            if(map.containsKey(sortedKey)){
                List<String> list = map.get(sortedKey);
                list.add(s);
                map.put(sortedKey, list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedKey, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
        
    }
}
