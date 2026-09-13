class Solution {
    private List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            ans.get(edge[0]).add(edge[1]);
        }
        return ans;
    }

    private Set<Integer> dfs(int node, List<List<Integer>> graph, Map<Integer, Set<Integer>> map){
        map.put(node, new HashSet<>());

        Set<Integer> set = new HashSet<>();
        List<Integer> neighbors = graph.get(node);
        for(int neighbor: neighbors){
            set.add(neighbor);
            if(!map.containsKey(neighbor)){
                set.addAll(dfs(neighbor, graph, map));
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

        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)){
                dfs(i, graph, map);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            ans.add(map.get(query[0]).contains(query[1]));
        }
        return ans;
    }
}