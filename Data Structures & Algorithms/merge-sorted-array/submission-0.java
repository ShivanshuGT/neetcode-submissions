class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m+n-1;
        int left = m-1;
        int right = n-1;

        while(right >= 0 && left >= 0){
            if(nums1[left] >= nums2[right]){
                nums1[x] = nums1[left];
                x -= 1;
                left -=1;
            }else{
                nums1[x] = nums2[right];
                x -= 1;
                right -= 1;
            }
        }

        while(right >= 0){
            nums1[x] = nums2[right];
            x -= 1;
            right -= 1;
        }
        
    }
}