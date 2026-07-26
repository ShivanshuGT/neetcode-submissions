class MyHashSet {

    private int getBucketIndex(int key){
        return key % 15000;
    }

    private List<Integer>[] buckets;

    public MyHashSet() {
        this.buckets = new ArrayList[15000];
    }
    
    public void add(int key) {
        int index = getBucketIndex(key);
        List<Integer> bucket = this.buckets[index];
        if(bucket == null){
            bucket = new ArrayList<>();
            bucket.add(key);
            this.buckets[index] = bucket;
        }
        if(!bucket.contains(key)){
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        List<Integer> bucket = this.buckets[getBucketIndex(key)];
        if(bucket == null){
            return;
        }
        if(bucket.contains(key)){
            bucket.remove((Object) key);
        }
    }
    
    public boolean contains(int key) {
        List<Integer> bucket = this.buckets[getBucketIndex(key)];
        return bucket != null && bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */