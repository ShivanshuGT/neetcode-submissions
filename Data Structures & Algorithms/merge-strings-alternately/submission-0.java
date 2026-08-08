class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left = 0;
        int right = 0;
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();

        while(left < n && right < m){
            sb.append(word1.charAt(left));
            sb.append(word2.charAt(right));
            left += 1;
            right += 1;
        }

        while(left < n){
            sb.append(word1.charAt(left));
            left += 1;
        }

        while(right < m){
            sb.append(word2.charAt(right));
            right += 1;
        }
        return sb.toString();
        
    }
}