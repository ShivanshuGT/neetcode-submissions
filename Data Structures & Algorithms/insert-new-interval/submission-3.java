class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {

        int i = 0;
        int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();

        // left portion
        while(i < n && arr[i][1] < newInterval[0]){
            ans.add(List.of(arr[i][0], arr[i][1]));
            i += 1;
        }

        // overlapping portion
        while(i < n && arr[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], arr[i][0]);
            newInterval[1] = Math.max(newInterval[1], arr[i][1]);
            i += 1;
        }

        ans.add(List.of(newInterval[0], newInterval[1]));

        // right portion
        while(i < n){
            ans.add(List.of(arr[i][0], arr[i][1]));
            i += 1;
        }

        int y = 0;
        int[][] answer = new int[ans.size()][2];

        for(List<Integer> ls : ans){
            int[] temp = new int[2];
            temp[0] = ls.get(0);
            temp[1] = ls.get(1);
            answer[y] = temp;
            y += 1;
        }
        return answer;
        
    }
}
