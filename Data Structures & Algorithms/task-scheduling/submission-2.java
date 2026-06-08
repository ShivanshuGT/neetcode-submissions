class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(entry.getValue());
        }

        int ans = 0;

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i<= n+1; i++){
                // we can process n tasks before pushing the same task
                // again in the queue
                if(!queue.isEmpty()){
                    int top = queue.poll();
                    top -= 1;
                    temp.add(top);
                }
                
            }

            // now we can again put these tasks again in the queue
            for(Integer t : temp){
                if(t > 0){
                    queue.add(t);
                }
                
            }

            if(queue.isEmpty()){
                ans += temp.size();
            }else{
                ans += n+1;
            }
        }
        return ans;

        
    }
}
