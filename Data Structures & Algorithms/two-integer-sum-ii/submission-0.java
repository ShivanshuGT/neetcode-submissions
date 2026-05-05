class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left += 1;
            }else if(sum > target){
                right -=1;
            }else{
                break;
            }
        }
        int[] ans = new int[2];
        ans[0] = left + 1;
        ans[1] = right + 1;
        return ans;
    }
}
