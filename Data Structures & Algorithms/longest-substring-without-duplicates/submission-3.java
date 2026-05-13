class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = 0;
        Character toBeRemoved = null;
        while(right < n){
            char ch = s.charAt(right);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
            if(freq > 0){
                toBeRemoved = ch;
            }
            if(toBeRemoved != null){
                char onLeft = s.charAt(left);
                int f = map.get(onLeft);
                if(f == 1){
                    map.remove(onLeft);
                }else{
                    map.put(onLeft, f-1);
                }
                left += 1;
            }
            if(toBeRemoved == null || map.getOrDefault(toBeRemoved, 0) <= 1){
                toBeRemoved = null;
                ans = Math.max(ans, right-left+1);
            }
            right += 1;
        }
        return ans;
        
    }
}
