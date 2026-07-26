class Pair{
    int key;
    int value;

    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class MyHashMap {

    private int getBucketIndex(int key){
        return key % 15000;
    }

    private List<Pair>[] buckets;

    public MyHashMap() {
        this.buckets = new ArrayList[15000];
        
    }
    
    public void put(int key, int value) {
        int index = getBucketIndex(key);
        List<Pair> bucket = this.buckets[index];

        if(bucket == null){
            Pair p = new Pair(key, value);
            bucket = new ArrayList();
            bucket.add(p);
            this.buckets[index] = bucket;
            return;
        }

        for(Pair p : bucket){
            if(p.key == key){
                p.value = value;
                return;
            }
        }

        bucket.add(new Pair(key, value));
        
    }
    
    public int get(int key) {
        int index = getBucketIndex(key);
        List<Pair> bucket = this.buckets[index];

        if(bucket == null){
            return -1;
        }

        for(Pair p : bucket){
            if(p.key == key){
                return p.value;
            }
        }

        return -1;
        
    }
    
    public void remove(int key) {
        int index = getBucketIndex(key);
        List<Pair> bucket = this.buckets[index];

        if(bucket == null){
            return;
        }

        for(Pair p : bucket){
            if(p.key == key){
                bucket.remove(p);
                return;
            }
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */