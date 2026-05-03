class Pair{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Pair> queue = new PriorityQueue<>((a,b) -> b.value-a.value);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            int freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] ans = new int[k];
        int x = 0;
        while(k > 0){
            ans[x] = queue.poll().key;
            x += 1;
            k -= 1;
        }
        return ans;
    }
}
