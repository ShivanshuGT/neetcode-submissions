class Solution {

    private void recursive(int n, Map<Integer, Integer> map, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == n){
            ans.add(List.copyOf(temp));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > 0){
                temp.add(key);
                map.put(key, value-1);
                recursive(n, map, ans, temp);
                temp.removeLast();
                map.put(key, value);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        recursive(n, map, ans, temp);
        return ans;
        
    }
}