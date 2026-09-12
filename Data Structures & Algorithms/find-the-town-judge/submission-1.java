class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int m = trust.length;

        for(int i = 1; i <= n; i++){
            map1.put(i, 0);
            map2.put(i, 0);
        }

        for(int i = 0; i < m; i++){
            int[] vote = trust[i];
            map1.put(vote[1], map1.get(vote[1]) + 1);
            map2.put(vote[0], map2.get(vote[0]) + 1);
        }

        int max = 0;
        int maxNode = -1;
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                maxNode = entry.getKey();
            }
        }
        if(max == n-1 && map2.get(maxNode) == 0){
            return maxNode;
        }
        return -1;
        
    }
}