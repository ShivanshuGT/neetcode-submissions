class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            rank.add(0);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int val = findParent(parent.get(node));
        parent.set(node, val);
        return val;
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(rank.get(pu) == rank.get(pv)){
            parent.set(pu, pv);
            rank.set(pv, rank.get(pv) + 1);
        }else if(rank.get(pu) > rank.get(pv)){
            parent.set(pv, pu);
        }else{
            parent.set(pu, pv);
        }
    }
}
class Solution {

    private int findMSTWeightUsingKruskalAlgorithm(int n, List<List<Integer>> edges, int skipEdge, int addEdge){

        DisjointSet ds = new DisjointSet(n);
        int ans = 0;

        if(addEdge != -1){
            ds.union(edges.get(addEdge).get(0), edges.get(addEdge).get(1));
            ans += edges.get(addEdge).get(2);
        }

        int e = edges.size();

        for(int i = 0; i < e; i++){

            if(skipEdge == i){
                continue;
            }
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int weight = edges.get(i).get(2);

            if(ds.findParent(u) != ds.findParent(v)){
                ds.union(u, v);
                ans += weight;
            }
        }

        // check if the MST is really formed or not
        for(int i = 0; i < n; i++){
            if(ds.findParent(i) != ds.findParent(0)){
                return Integer.MAX_VALUE;
            }
        }
        return ans;

    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] arr) {

        List<List<Integer>> edges = new ArrayList<>();

        int e = arr.length;

        for(int i = 0; i < e; i++){
            edges.add(List.of(arr[i][0], arr[i][1], arr[i][2], i));
        }

        Collections.sort(edges, Comparator.comparingInt(entry -> entry.get(2)));

        int mstWeight = findMSTWeightUsingKruskalAlgorithm(n, edges, -1, -1);
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        for(int i = 0; i < e; i++){
            if(mstWeight < findMSTWeightUsingKruskalAlgorithm(n, edges, i, -1)){
                criticalEdges.add(edges.get(i).get(3));
            }else if(mstWeight == findMSTWeightUsingKruskalAlgorithm(n, edges, -1, i)){
                pseudoCriticalEdges.add(edges.get(i).get(3));
            }
        }

        return List.of(criticalEdges, pseudoCriticalEdges);


        
    }
}