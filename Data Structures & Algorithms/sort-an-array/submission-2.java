class Solution {

    private void merge(int[] arr, int beg, int mid, int end){
        List<Integer> temp = new ArrayList<>();

        int left = beg;
        int right = mid+1;

        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left += 1;
            }else{
                temp.add(arr[right]);
                right += 1;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left += 1;
        }

        while(right <= end){
            temp.add(arr[right]);
            right += 1;
        }

        for(int i = beg; i <= end; i++){
            arr[i] = temp.get(i - beg);
        }
    }

    private void mergeSort(int[] arr, int beg, int end){
        if(beg == end){
            return ;
        }

        int mid = (beg + end) / 2;
        mergeSort(arr, beg, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, beg, mid, end);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}