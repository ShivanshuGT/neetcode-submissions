class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> temp = new ArrayList<>();

        int carry = 1;
        int n = digits.length;

        for(int i = n-1; i >= 0; i--){
            int sum = digits[i] + carry;
            if(sum == 10){
                carry = 1;
                temp.add(0, 0);
            }else{
                carry = 0;
                temp.add(0, sum);
            }
        }

        if(carry == 1){
            temp.add(0, 1);
        }


        int[] ans = new int[temp.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
