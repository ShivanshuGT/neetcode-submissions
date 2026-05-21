class Solution {

    private boolean isValidWindow(Map<Character, Integer> s, Map<Character, Integer> t){
        for(Map.Entry<Character, Integer> entry : t.entrySet()){
            if(entry.getValue() > s.getOrDefault(entry.getKey() , 0)){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }else{
            int n = s.length();
            int left = 0;
            int right = 0;
            int ansLeft = -1;
            int ansRight = -1;
            int minLength = Integer.MAX_VALUE;
            Map<Character, Integer> tMap = new HashMap<>();
            for(char c: t.toCharArray()){
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> map = new HashMap<>();
            while(right < n){
                char ch = s.charAt(right);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                while(isValidWindow(map, tMap)){
                    if(minLength > (right-left+1)){
                        minLength = right-left+1;
                        ansLeft = left;
                        ansRight = right;
                    }
                    char atLeft = s.charAt(left);
                    int freq = map.get(atLeft);
                    if(freq == 1){
                        map.remove(atLeft);
                    }else{
                        map.put(atLeft, freq-1);
                    }
                    left += 1;
                }
                right += 1;
            }
            if(ansLeft == -1){
                return "";
            }else{
                return s.substring(ansLeft, ansRight+1);
            }
        }
        
        
    }
}
