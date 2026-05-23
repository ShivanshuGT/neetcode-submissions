class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        SortedMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        ans[0] = map.firstKey();
        int x = 1;
        int left = 0;
        int right = k;
        while(right < n){
            int atLeft = nums[left];
            int atRight = nums[right];
            int freqLeft = map.get(atLeft);
            if(freqLeft == 1){
                map.remove(atLeft);
            }else{
                map.put(atLeft, freqLeft-1);
            }
            map.put(atRight, map.getOrDefault(atRight, 0)+1);
            ans[x] = map.firstKey();
            x += 1;
            left += 1;
            right += 1;
        }
        return ans;
        
    }
}
