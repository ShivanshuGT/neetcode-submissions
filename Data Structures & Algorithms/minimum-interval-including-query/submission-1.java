class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        int n = intervals.length;
        int m = queries.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++){
            map.put(queries[i], -1);
        }

        for(int i = 0; i < n; i++){
            int[] interval = intervals[i];

            int start = interval[0];
            int end = interval[1];
            int ans = end - start + 1;

            for(int j = start; j <= end; j++){
                if(map.containsKey(j) && map.get(j) == -1){
                    map.put(j, ans);
                }
            }
        }

        int[] answer = new int[m];
        for(int i = 0; i < m; i++){
            answer[i] = map.get(queries[i]);
        }
        return answer;
        
    }
}
