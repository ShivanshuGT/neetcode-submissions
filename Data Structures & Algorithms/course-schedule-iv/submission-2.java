class Solution {
    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            ans.get(u).add(v);
        }
        return ans;
    }

    private Set<Integer> dfs(int node, List<List<Integer>> graph, int[] visited, Map<Integer, Set<Integer>> map){
        visited[node] = 1;

        Set<Integer> set = new HashSet<>();
        List<Integer> neighbors = graph.get(node);
        for(int neighbor: neighbors){
            set.add(neighbor);
            if(visited[neighbor] != 1){
                set.addAll(dfs(neighbor, graph, visited, map));
            }else{
                set.addAll(map.get(neighbor));
            }
        }
        map.put(node, set);
        return set;
        
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Map<Integer, Set<Integer>> map = new HashMap<>();

        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] != 1){
                dfs(i, graph, visited, map);
            }
        }

        // for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
        //     System.out.print(entry.getKey() + " --> " + entry.getValue());
        // }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            ans.add(map.get(u).contains(v));
        }
        return ans;
    }
}