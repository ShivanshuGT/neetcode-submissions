class Solution {

    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;

        for(int i = 0; i < e; i++){
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private void dfs(List<List<Integer>> graph, int[] visited, int node){
        visited[node] = 1;

        List<Integer> neighbours = graph.get(node);

        for(int neighbour : neighbours){
            if(visited[neighbour] == 0){
                dfs(graph, visited, neighbour);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        int[] visited = new int[n];

        List<List<Integer>> graph = buildGraph(n, edges);

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                ans += 1;
                dfs(graph, visited, i);
            }
        }
        return ans;

    }
}
