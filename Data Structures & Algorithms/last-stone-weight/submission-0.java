class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int n = stones.length;
        for(int x : stones){
            queue.add(x);
        }

        while(queue.size() > 1){
            int top1 = queue.poll(); // heaviest
            int top2 = queue.poll(); // second heaviest

            if(top1 == top2){
                continue;
            }else{
                // top1 > top2
                queue.add(top1 - top2);
            }
        }

        return queue.size() == 1 ? queue.peek() : 0;
        
    }
}
