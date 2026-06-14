class Solution {

    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;

        for(int  i = 0; i < e; i++){
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node, int parent){
        visited[node] = 1;

        List<Integer> neighbours = graph.get(node);
        for(int neighbour : neighbours){
            if(visited[neighbour] == 0){
                if(dfs(graph, visited, neighbour, node)){
                    return true;
                }
            }else{
                if(neighbour == parent){
                    continue;
                }else{
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(int n, int[][] edges, int[] count){
        List<List<Integer>> graph = buildGraph(n, edges);

        int[] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                count[0] += 1;
                if(dfs(graph, visited, i, -1)){
                    
                    return true;
                }
            }
        }
        return false ;
    }
    public boolean validTree(int n, int[][] edges) {
        int[] count = new int[1];
        boolean hasCycle = hasCycle(n, edges, count);
        if(hasCycle){
            return false;
        }else{
            System.out.println(count);
            if(count[0] > 1){
                return false;
            }else{
                return true;
            }
        }
        

    }
}
