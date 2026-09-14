class DisjointSet{
    List<Integer> parent;
    List<Integer> rank;

    DisjointSet(int n){
        this.parent = new ArrayList<>();
        this.rank = new ArrayList<>();
        for(int i = 0; i < n; i++){
            parent.add(i);
            rank.add(0);
        }
    }

    private int getParent(int node){
        if(parent.get(node) == node){
            return node;
        }
        int val = getParent(parent.get(node));
        parent.set(node, val);
        return val;
    }

    private void unionByRank(int u, int v){
        int pu = getParent(u);
        int pv = getParent(v);

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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        DisjointSet dj = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int m = accounts.get(i).size();

            for(int j = 1; j < m; j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    dj.unionByRank(map.get(mail), i);
                }else{
                    map.put(mail, i);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            temp.add(new ArrayList<>());
        }

        // traverse over the map
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int node = dj.getParent(entry.getValue());
            temp.get(node).add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<String> values = temp.get(i);
            if(values.isEmpty()){
                continue;
            }

            Collections.sort(values);
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(i).get(0));
            ls.addAll(values);
            ans.add(ls);
        }
        return ans;
        
    }
}