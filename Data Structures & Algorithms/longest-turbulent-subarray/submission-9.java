class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int n = arr.length;

        int ans = 1;
        String sign = "";

        while(right < n){
            if(arr[right-1] > arr[right] && !">".equals(sign)) {
                ans = Math.max(ans, right - left + 1);
                right += 1;
                sign = ">";
            }else if(arr[right-1] < arr[right] && !"<".equals(sign)){
                ans = Math.max(ans, right - left + 1);
                right += 1;
                sign = "<";
            }else{
                if(arr[right-1] == arr[right]){
                    right += 1;
                }
                left = right - 1;
                sign = "";
            }
        }
        return ans;
        
    }
}