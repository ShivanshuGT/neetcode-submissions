class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left < right){

            while((left < right) && !Character.isLetterOrDigit(s.charAt(left))){
                left += 1;

            }
            while((left < right) && !Character.isLetterOrDigit(s.charAt(right))){
                right -= 1;
            }
            if((left < right) && !(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)))){
                System.out.println(left);
                System.out.println(right);
                System.out.println(s.charAt(left));
                System.out.println(s.charAt(right));
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
