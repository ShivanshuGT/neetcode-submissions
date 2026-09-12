class Solution {

    private boolean compareWords(String word1, String word2, Map<Character, Integer> map){
        int n1 = word1.length();
        int n2 = word2.length();

        int i = 0;
        int j = 0;

        while(i < n1 && j < n2){
            if(word1.charAt(i) == word2.charAt(j)){
                i += 1;
                j += 1;
            }else{
                int o1 = map.get(word1.charAt(i));
                int o2 = map.get(word2.charAt(j));
                if(o1 < o2){
                    return true;
                }
                else{
                    return false;
                }
            }
        }

        if(j == n2 && i < n1){
            return false;
        }
        return true;

    }
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        int x = 0;
        for(char ch : order.toCharArray()){
            map.put(ch, x);
            x += 1;
        }

        int n = words.length;
        for(int i = 0; i < n-1; i++){
            if(!compareWords(words[i], words[i+1], map)){
                return false;
            }

        }
        return true;
        
    }
}