class Pair{
    int timestamp;
    String value;
    Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {

    private Map<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = this.map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = this.map.getOrDefault(key, new ArrayList<>());
        if(list.isEmpty()){
            return "";
        }
        int left = 0;
        int right = list.size() -1;
        String ans = "";
        while(left <= right){
            int mid = (left + right)/ 2;
            if(list.get(mid).timestamp <= timestamp){
                ans = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
