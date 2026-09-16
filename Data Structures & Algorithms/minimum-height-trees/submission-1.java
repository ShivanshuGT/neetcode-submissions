class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return List.of(0);
        }

        int e = edges.length;
        int[] degree = new int[n];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            degree[u] += 1;
            degree[v] += 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                queue.add(i);
            }
        }

        int currentNodes = n;

        while(currentNodes > 2){
            int size = queue.size();
            currentNodes -= size;

            while(size > 0){
                int node = queue.poll();
                List<Integer> neighbors = graph.get(node);
                for(int neighbor : neighbors){
                    degree[neighbor] -= 1;
                    if(degree[neighbor] == 1){
                        queue.add(neighbor);
                    }
                }
                size -= 1;
            }
            
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
        
    }
}