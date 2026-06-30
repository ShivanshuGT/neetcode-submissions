class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(-2, -1));

        int i = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        while(i < n){
            List<Integer> last = ans.get(ans.size()-1);
            int[] interval = new int[2];
            interval[0] = last.get(0);
            interval[1] = last.get(1);
            int[] newInterval = intervals[i];

            if(interval[1] < newInterval[0]){
                // non-overlapping
                ans.add(List.of(newInterval[0], newInterval[1]));
            }else if(interval[0] < newInterval[1]){
                // overlapping
                ans.remove(ans.size()-1);
                interval[0] = Math.min(interval[0], newInterval[0]);
                interval[1] = Math.max(interval[1], newInterval[1]);
                ans.add(List.of(interval[0], interval[1]));
            }
            i += 1;
        }

        ans.remove(0);

        int[][] answer = new int[ans.size()][2];
        int z = 0;
        for(List<Integer> ls : ans){
            int[] temp = new int[2];
            temp[0] = ls.get(0);
            temp[1] = ls.get(1);
            answer[z] = temp;
            z += 1;
        }
        return answer;
        
    }
}
