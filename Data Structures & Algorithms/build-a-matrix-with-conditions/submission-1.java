class Solution {

    private List<List<Integer>> buildGraph(int n, int[][] arr){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: arr){
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    private void dfs(int node, int[] visited, List<List<Integer>> graph, Stack<Integer> stack){
        visited[node] = 1;

        List<Integer> neighbors = graph.get(node);
        for(int neighbor : neighbors){
            if(visited[neighbor] != 1){
                dfs(neighbor, visited, graph, stack);
            }
        }
        stack.add(node);
    }

    private boolean dfs2(int node, int[] visited, int[] pathVisited, List<List<Integer>> graph){
        visited[node] = 1;
        pathVisited[node] = 1;

        List<Integer> neighbors = graph.get(node);
        for(int neighbor : neighbors){
            if(visited[neighbor] == 0){
                if(dfs2(neighbor, visited, pathVisited, graph)){
                    return true;
                }
            }else{
                if(pathVisited[neighbor] == 1){
                    return true;
                }
            }
        }

        pathVisited[node] = 0;
        return false;
    }

    private boolean detectCycle(int n, List<List<Integer>> graph){
        int[] visited = new int[n+1];
        int[] pathVisited = new int[n+1];

        for(int i = 0; i <= n; i++){
            if(visited[i] != 1){
                if(dfs2(i, visited, pathVisited, graph)){
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Integer, Integer> topoSort(int n, List<List<Integer>> graph){
        int[] visited = new int[n+1];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= n; i++){
            if(visited[i] != 1){
                dfs(i, visited, graph, stack);
            }
        }

        Map<Integer, Integer> ans = new HashMap<>();
        int x = 0;

        while(!stack.isEmpty()){
            ans.put(stack.pop(), x);
            x += 1;
        }
        return ans;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<List<Integer>> graph1 = buildGraph(k, rowConditions);
        List<List<Integer>> graph2 = buildGraph(k, colConditions);

        if(detectCycle(k, graph1) || detectCycle(k, graph2)){
            return new int[0][0];
        }

        Map<Integer, Integer> rowMap = topoSort(k, graph1);
        Map<Integer, Integer> colMap = topoSort(k, graph2);

        int[][] ans = new int[k][k];

        int x = 1;

        while(x <= k){
            ans[rowMap.get(x)][colMap.get(x)] = x;
            x += 1;
        }
        return ans;

        
    }
}