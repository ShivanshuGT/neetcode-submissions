class Solution {

    private String encodeLength(int length){
        return String.format("%03d", length);
    }

    private int decodeLength(String s){
        return Integer.parseInt(s);
    }

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            ans.append(encodeLength(length));
            ans.append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int n = str.length();
        int x = 0;
        while(x < n){
            int length = decodeLength(str.substring(x, x+3));
            x = x+3;
            ans.add(str.substring(x, x+length));
            x = x+length;
        }
        return ans;
    }
}
