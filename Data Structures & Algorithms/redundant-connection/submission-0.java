class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            parent.add(i);
            rank.add(0);
        }
    }

    int findParent(int node){
        if(parent.get(node) == node){
            return node;
        }

        int val = findParent(parent.get(node));
        parent.set(node, val);
        return val;
    }

    void groupByRank(int u, int v){
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(rank.get(parentU) == rank.get(parentV)){
            parent.set(parentU, parentV);
            rank.set(parentV, rank.get(parentV) + 1);
        }else if(rank.get(parentU) > rank.get(parentV)){
            parent.set(parentV, parentU);
        }else{
            parent.set(parentU, parentV);
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i  = 0; i < n ; i++){
            int[] edge = edges[i];

            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                return edge;
            }else{
                ds.groupByRank(u, v);
            }
        }
        return new int[2];
        
    }
}
