class Solution {

    private static int findMaxLessThanOrEqualIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int ans = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] <= target){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    private static int getX2(int[] nums1, int[] nums2, int p1, int p2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(p1 < n1 && p2 < n2){
            if(nums1[p1] <= nums2[p2]){
                return nums1[p1];
            }else{
                return nums2[p2];
            }
        }

        if(p1 < n1){
            return nums1[p1];
        }
        if(p2 < n2){
            return nums2[p2];
        }
        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 == 0){
            if(n2 % 2 == 0){
                int x1 = nums2[(n2/2) -1];
                int x2 = nums2[n2/2];
                return (((double)x1 ) + x2 )/2;
            }else{
                return nums2[n2/2];
            }
        }
        if(n2 == 0){
            if(n1 % 2 == 0){
                int x1 = nums1[(n1/2) -1];
                int x2 = nums1[n1/2];
                return (((double)x1 ) + x2 )/2;
            }else{
                return nums1[n1/2];
            }
        }

        int mid1 = (0 + n1 - 1)/2;
        int mid2 = (0 + n2 -1)/2;
        if((n1 + n2 ) % 2 != 0){
            int required = (n1 + n2 + 1)/ 2;
            if(nums1[mid1] <= nums2[mid2]){
                int c = findMaxLessThanOrEqualIndex(nums2, nums1[mid1]);
                int el = mid1 + c + 2;
                int p1 = mid1 + 1;
                int p2 = c + 1;
                while((p1 < n1) && (p2 < n2) && (el < required)){
                    if(nums1[p1] <= nums2[p2]){
                        
                        el += 1;
                        if(el == required)
                        return nums1[p1];
                        p1 += 1;
                    }
                    else{
                        
                        el += 1;
                        if(el == required)
                        return nums2[p2];
                        p2 += 1;
                    
                    }
                }
                if((p1 < n1) && (el < required)){
                    p1 += (required - el);
                    return nums1[p1];
                }
                if((p2 < n2) && (el < required)){
                    p2 += (required - el);
                    return nums2[p2];
                }
            }else{
                int c = findMaxLessThanOrEqualIndex(nums1, nums2[mid2]);
                int el = mid2 + c + 2;
                int p1 = c + 1;
                int p2 = mid2 + 1;
                while((p1 < n1) && (p2 < n2) && (el < required)){
                    if(nums1[p1] <= nums2[p2]){
                        
                        el += 1;
                        if(el == required)
                        return nums1[p1];
                        p1 += 1;
                    }
                    else{
                        
                        el += 1;
                        if(el == required)
                        return nums2[p2];
                        p2 += 1;
                    
                    }
                }
                if((p1 < n1) && (el < required)){
                    p1 += (required - el);
                    return nums1[p1];
                }
                if((p2 < n2) && (el < required)){
                    p2 += (required - el);
                    return nums2[p2];
                }
            }
        }else{
            int required = (n1 + n2)/ 2;
            if(nums1[mid1] <= nums2[mid2]){
                int c = findMaxLessThanOrEqualIndex(nums2, nums1[mid1]);
                int el = mid1 + c + 2;
                int p1 = mid1 + 1;
                int p2 = c + 1;
                if(el == required){
                    int x1 = nums1[mid1];
                    int x2 = getX2(nums1, nums2, mid1+1, mid2+1);
                    return ((double)(x1) + x2)/2;
                }
                while((p1 < n1) && (p2 < n2) && (el < required)){
                    if(nums1[p1] <= nums2[p2]){
                        
                        el += 1;
                        if(el == required){
                            int x1 = nums1[p1];
                            p1 += 1;
                            int x2 = getX2(nums1, nums2, p1, p2);
                            return ((double)(x1) + x2)/2;
                        }
                        p1 += 1;
                    }
                    else{
                        
                        el += 1;
                        if(el == required)
                        {
                            int x1 = nums2[p2];
                            p2 += 1;
                            int x2 = getX2(nums1, nums2, p1, p2);
                            return ((double)(x1) + x2)/2;  
                        }
                        p2 += 1;
                    
                    }
                }
                if((p1 < n1) && (el < required)){
                    p1 += (required - el);
                    int x1 =  nums1[p1];
                    int x2 = nums1[p1+1];
                    return ((double)(x1) + x2)/2; 
                }
                if((p2 < n2) && (el < required)){
                    p2 += (required - el);
                    int x1 =  nums2[p2];
                    int x2 = nums2[p2+1];
                    return ((double)(x1) + x2)/2; 
                }
            }else{
                int c = findMaxLessThanOrEqualIndex(nums1, nums2[mid2]);
                int el = mid2 + c + 2;
                int p1 = c + 1;
                int p2 = mid2 + 1;
                while((p1 < n1) && (p2 < n2) && (el < required)){
                    if(nums1[p1] <= nums2[p2]){
                        
                        el += 1;
                        if(el == required){
                            int x1 = nums1[p1];
                            p1 += 1;
                            int x2 = getX2(nums1, nums2, p1, p2);
                            return ((double)(x1) + x2)/2;
                        }
                        p1 += 1;
                    }
                    else{
                        
                        el += 1;
                        if(el == required)
                        {
                            int x1 = nums2[p2];
                            p2 += 1;
                            int x2 = getX2(nums1, nums2, p1, p2);
                            return ((double)(x1) + x2)/2;  
                        }
                        p2 += 1;
                    
                    }
                }
                if((p1 < n1) && (el < required)){
                    p1 += (required - el);
                    int x1 =  nums1[p1];
                    int x2 = nums1[p1+1];
                    return ((double)(x1) + x2)/2; 
                }
                if((p2 < n2) && (el < required)){
                    p2 += (required - el);
                    int x1 =  nums2[p2];
                    int x2 = nums2[p2+1];
                    return ((double)(x1) + x2)/2; 
                }
                
            }
        }
        return 0;
        
    }
}
