
class Solution {

    private Map<String, List<String>> buildGraph(List<List<String>> tickets){
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if(graph.containsKey(source)){
                graph.get(source).add(destination);
            }else{
                List<String> ls = new ArrayList<>();
                ls.add(destination);
                graph.put(source, ls);
            }
        }
        return graph;
    }

    private boolean dfs(String node, int n, List<String> path, Map<String, List<String>> graph){
        path.add(node);
        if(n+1 == path.size()){
            return true;
        }

        List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());

        int m = neighbors.size();
        for(int i = 0; i < m; i++){
            String neighbor = neighbors.get(i);
            neighbors.remove(i);
            if(dfs(neighbor, n, path, graph)){
                return true;
            }
            neighbors.add(i, neighbor);
        }

        path.removeLast();
        return false;


    }

    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        Collections.sort(tickets, Comparator.comparing((List<String> t) ->  t.get(0)).thenComparing(t -> t.get(1)));
        Map<String, List<String>> graph = buildGraph(tickets);
        List<String> path = new ArrayList<>();
        dfs("JFK", n, path, graph);
        return path;
        
    }
}
