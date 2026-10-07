class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    int numberOfComponents = 0;

    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            rank.add(0);
        }
        this.numberOfComponents = n;
    }

    public int getParent(int node){
        if(this.parent.get(node) == node){
            return node;
        }

        int val = getParent(parent.get(node));
        parent.set(node, val);
        return val;
    }

    public void union(int u, int v){
        int pu = getParent(u);
        int pv = getParent(v);

        if(pu == pv){
            return;
        }

        if(rank.get(pu) == rank.get(pv)){
            parent.set(pu, pv);
            rank.set(pv, rank.get(pv) + 1);
        }else if(rank.get(pu) > rank.get(pv)){
            parent.set(pv, pu);
        }else{
            parent.set(pu, pv);
        }
        this.numberOfComponents -= 1;
    }

    public int getNumberOfComponents(){
        return this.numberOfComponents;
    }
}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {

        int n = nums.length;
        if(n == 1){
            return true;
        }

        DisjointSet ds = new DisjointSet(n);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int x = nums[i];
            if(x == 1){
                return false;
            }
            for(int factor = 2; factor*factor <= x; factor++){
                if(x % factor != 0){
                    continue;
                }else{
                    if(map.containsKey(factor)){
                        ds.union(map.get(factor), i);
                    }else{
                        map.put(factor, i);
                    }

                    while(x % factor == 0){
                        x = x/factor;
                    }
                }
            }
            if(x > 1){
                if(map.containsKey(x)){
                    ds.union(map.get(x), i);
                }else{
                    map.put(x, i);
                }
            }
                
            
        }

        return ds.getNumberOfComponents() == 1;
        
    }
}