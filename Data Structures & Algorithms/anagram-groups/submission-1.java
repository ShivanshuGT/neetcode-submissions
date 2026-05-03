class Solution {

    private static boolean areAnagrams(String s1, String s2){
        int[] hash = new int[26];

        for(int i = 0; i< s1.length(); i++){
            hash[s1.charAt(i)-'a'] += 1;
        }
        for(int i = 0; i< s2.length(); i++){
            hash[s2.charAt(i)-'a'] -= 1;
        }

        for(int i = 0; i< 26;i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map2.containsKey(i)){
                continue;
            }
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(strs[i], list);
            map2.put(i, i);
            for(int j=i+1; j < n; j++){
                if(map2.containsKey(strs[j])){
                    continue;
                }
                if(areAnagrams(strs[i], strs[j])){
                    List<String> list2 = map.getOrDefault(strs[i], new ArrayList<>());
                    list2.add(strs[j]);
                    map.put(strs[i], list2);
                    map2.put(j, i);
                }
            }

            
        }
        List<List<String>> ans = new ArrayList<>();
            for(List<String> list : map.values()){
                ans.add(list);
            }
        return ans;
        
    }
}
