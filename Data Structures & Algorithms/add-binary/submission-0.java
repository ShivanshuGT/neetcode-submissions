class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n1 = a.length();
        int n2 = b.length();

        int i = n1-1;
        int j = n2-1;

        int carry = 0;
        int sum = 0;
        while(i >= 0 || j >= 0){
            sum = 0;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i -= 1;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j -= 1;
            }
            sum += carry;
            if(sum >= 2){
                carry = 1;
            }else{
                carry = 0;
            }
            sum = sum % 2;
            ans.append(sum);
            
        }

        if(carry == 1){
            ans.append('1');
        }
        return ans.reverse().toString();
        
    }
}