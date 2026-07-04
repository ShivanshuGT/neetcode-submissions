class Pair{
    int len;
    int rightValue;

    Pair(int len, int rightValue){
        this.len = len;
        this.rightValue = rightValue;
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = intervals.length;
        int m = queries.length;
        int[] queriesTemp = new int[m];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < m ; i++){
            queriesTemp[i] = queries[i];
        }
        Arrays.sort(queriesTemp);

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.len).thenComparing(p -> p.rightValue));

        
        int i = 0;
        int j = 0;

        while(i  < m){
            int query = queriesTemp[i];
            while(j < n && query >= intervals[j][0]){
                queue.add(new Pair(intervals[j][1] - intervals[j][0] + 1, intervals[j][1]));
                j += 1;
            }

            // pop invalid values from the minHeap
            while(!queue.isEmpty() && queue.peek().rightValue < query){
                queue.poll();
            }
            // store the answer
            if(!queue.isEmpty()){
                map.put(query, queue.peek().len);
            }
            i += 1;

        }

        int[] ans = new int[m];
        for(int x = 0; x < m ; x++){
            ans[x] = map.getOrDefault(queries[x], -1);
        }
        return ans;
        
    }
}
