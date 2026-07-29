class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // there can be atmost 2 such elements such present

        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            }else if(nums[i] == el1){
                cnt1 += 1;
            }else if(nums[i] == el2){
                cnt2 += 1;
            }else{
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }

        // mannual check for el1 and el2
        int threshold = n/3;
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == el1){
                cnt1 +=1;
            }
            if(nums[i] == el2){
                cnt2 += 1;
            }
        }

        List<Integer> temp = new ArrayList<>();
        if(cnt1 > threshold){
            temp.add(el1);
        }

        if(cnt2 > threshold){
            temp.add(el2);
        }

        return temp;
        
    }
}