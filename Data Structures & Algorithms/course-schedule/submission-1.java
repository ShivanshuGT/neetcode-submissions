class Solution {

    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;

        for(int i = 0; i < e; i++){
            int[] edge = edges[i];
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int[] pathVisited, int node){
        visited[node] = 1;
        pathVisited[node] = 1;

        List<Integer> neighbours = graph.get(node);

        for(int neighbour : neighbours){
            if(visited[neighbour] == 0){
                if(dfs(graph, visited, pathVisited, neighbour)){
                    return true;
                }
            }else{
                if(pathVisited[neighbour] == 1){
                    return true;
                }
            }
        }
        pathVisited[node] = 0;
        return false;
    }

    private boolean hasCycle(int n, int[][] edges){
        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        List<List<Integer>> graph = buildGraph(n, edges);

        for(List<Integer> g : graph){
            System.out.println(g);
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(graph, visited, pathVisited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !hasCycle(numCourses, prerequisites);
    }
}
