class Pair{
    int node;
    double weight;

    Pair(int node, double weight){
        this.node = node;
        this.weight = weight;
    }
}

private boolean dfs(Map<Integer, List<Pair>> graph, int node, int target, int visited[], double[] ans){
    visited[node] = 1;

    if(node == target){
        return true;
    }

    List<Pair> neighbors = graph.get(node);
    for(Pair neighbor : neighbors){
        if(visited[neighbor.node] != 1){
            double temp = ans[0];
            ans[0] = ans[0] * neighbor.weight;
            if(dfs(graph, neighbor.node, target, visited, ans)){
                return true;
            }
            ans[0] = temp;
        }
    }
    return false;
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<Pair>> graph = new HashMap<>();
        int x = 0;

        int n = equations.size();

        for(int i = 0; i < n; i++){
            List<String> eq = equations.get(i);
            String var1 = eq.get(0);
            String var2 = eq.get(1);

            if(!map.containsKey(var1)){
                map.put(var1, x);
                x += 1;
            }

            if(!map.containsKey(var2)){
                map.put(var2, x);
                x += 1;
            }

            if(graph.containsKey(map.get(var1))){
                graph.get(map.get(var1)).add(new Pair(map.get(var2), values[i]));
            }else{
                List<Pair> ls = new ArrayList<>();
                ls.add(new Pair(map.get(var2), values[i]));
                graph.put(map.get(var1), ls);
            }

            if(graph.containsKey(map.get(var2))){
                graph.get(map.get(var2)).add(new Pair(map.get(var1), 1/values[i]));
            }else{
                List<Pair> ls = new ArrayList<>();
                ls.add(new Pair(map.get(var1), 1/values[i]));
                graph.put(map.get(var2), ls);
            }

            
        }

        int q = queries.size();
        double[] ans = new double[q];

        for(int i = 0; i < q; i++){
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            if(!map.containsKey(start) || !map.containsKey(end)){
                ans[i] = -1.0;
                continue;
            }

            int[] visited = new int[graph.size()];
            double[] arr = new double[1];
            arr[0] = 1;
            if(dfs(graph, map.get(start), map.get(end), visited, arr)){
                ans[i] = arr[0];
            }else{
                ans[i] = -1.0;
            }


        }
        return ans;
    }
}