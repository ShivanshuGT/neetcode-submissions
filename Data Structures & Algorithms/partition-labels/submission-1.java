class Solution {
    public List<Integer> partitionLabels(String s) {

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), i);
        }

        int i = 0;

        List<Integer> ans = new ArrayList<>();
        int start = -1;
        int end = -1;

        while(i < n){
            int ind = map.get(s.charAt(i));
            end = Math.max(end, ind);
            if(i == end){
                ans.add(i - start);
                start = i;
                i = end+1;
                
            }
            else{
                i = i + 1;
                // end = Math.max(end, ind);
            }
        }
        return ans;
        
    }
}
