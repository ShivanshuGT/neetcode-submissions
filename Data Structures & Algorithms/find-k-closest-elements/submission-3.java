class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int count = 0;
        int maxD = Integer.MIN_VALUE;

        while(right < n){

            if(count < k){
                maxD = Math.max(maxD, Math.abs(x - arr[right]));
                count += 1;
                
            }else{
                if(Math.abs(x - arr[right]) < maxD){
                    left += 1;
                    ansLeft = left;
                    // maxD = Math.min(maxD, Math.abs(x - arr[left]));
                    maxD = Math.abs(x - arr[left]);
                }
                
            }
            right += 1;

        }
        List<Integer> ans = new ArrayList<>();
        int i = ansLeft;
        while(count > 0){
            ans.add(arr[i]);
            i += 1;
            count -= 1;
        }
        return ans;
        
    }
}