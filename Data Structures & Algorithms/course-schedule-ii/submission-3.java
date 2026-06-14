class Solution {

    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;

        for(int i = 0; i < e; i++){
            int[] edge = edges[i];
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private boolean dfsCheck(List<List<Integer>> graph, int[] visited, int[] pathVisited, int node){
        visited[node] = 1;
        pathVisited[node] = 1;

        List<Integer> neighbours = graph.get(node);

        for(int neighbour : neighbours){
            if(visited[neighbour] == 0){
                if(dfsCheck(graph, visited, pathVisited, neighbour)){
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

    private void dfs(List<List<Integer>> graph, int[] visited, int node, List<Integer> ans){
        visited[node] = 1;
        ans.add(node);

        List<Integer> neighbours = graph.get(node);

        for(int neighbour : neighbours){
            ans.remove((Object) neighbour);
            visited[neighbour] = 0;
            dfs(graph, visited, neighbour, ans);
        }


    }

    private boolean hasCycle(List<List<Integer>> graph, int n){
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for(int i = 0; i < n ; i++){
            if(visited[i] == 0){
                if(dfsCheck(graph, visited, pathVisited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        if(hasCycle(graph, numCourses)){
            return new int[0];
        }else{
            List<Integer> ans = new ArrayList<>();
            int[] visited = new int[numCourses];
            for(int i = 0; i< numCourses; i++){
                if(visited[i] == 0){
                    dfs(graph, visited, i, ans);
                }
                
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
            
        }
        
    }
}
