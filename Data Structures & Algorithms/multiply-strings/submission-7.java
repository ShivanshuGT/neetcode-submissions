class Solution {
    public String multiply(String num1, String num2) {

        int n = num1.length();
        int m = num2.length();
        
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] arr = new int[n + m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i+j] += digit;
                arr[i+j+1] += arr[i+j] / 10;
                arr[i+j] = arr[i+j] % 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        int x = arr.length-1;
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] == 0){
                x -= 1;
            }else{
                break;
            }
        }

        while(x >= 0){
            ans.append((char)(arr[x] + '0'));
            x -= 1;
        }
        return ans.toString();

        
    }
}
