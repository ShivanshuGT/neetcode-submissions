class Solution {
    private boolean isValid(Map<Character, Integer> map, int k){
        if(map.size() <= 1){
            return true;
        }else{
            char maxFreqKey = '0';
            int maxFreq = 0;
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() > maxFreq){
                    maxFreq = entry.getValue();
                    maxFreqKey = entry.getKey();
                }
            }
            int totalReplacementsRequried = 0;
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(!(entry.getKey() == maxFreqKey)){
                    totalReplacementsRequried += entry.getValue();
                    if(totalReplacementsRequried > k){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = 1;
        Map<Character, Integer> map = new HashMap<>();
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(isValid(map, k)){
                ans = Math.max(ans, right-left+1);
            }else{
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
        return ans;
        
    }
}
