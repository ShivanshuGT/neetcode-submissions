class Solution {

    private boolean isPermutation(String s1, String s2){
        int[] arr = new int[26];
        for(char c : s1.toCharArray()){
            arr[c-'a'] += 1;
        }
        for(char c : s2.toCharArray()){
            arr[c-'a'] -= 1;
        }
        for(int x : arr){
            if(x > 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }else{
            int n = s2.length();
            int left = 0;
            int right = left + s1.length() - 1;
            while(right < n){
                String sub = s2.substring(left, right+1);
                if(isPermutation(s1, sub)){
                    return true;
                }else{
                    left += 1;
                    right += 1;
                }
            }
            return false;
        }
        
    }
}
