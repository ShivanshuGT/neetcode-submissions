class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        int n = hand.length;

        Arrays.sort(hand);

        for(int i = 0; i < n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while(map.size() > 0){
            int key = map.firstKey();
            if(map.get(key) == 1){
                map.remove(key);
            }else{
                map.put(key, map.get(key)-1);
            }
            int count = 1;
            while(count < groupSize){
                key = key + 1;
                if(!map.containsKey(key)){
                    return false;
                }else{
                    int freq = map.get(key);
                    if(freq == 1){
                        map.remove(key);
                    }else{
                        map.put(key, freq-1);
                    }
                }
                count += 1;
            }
        }
        return true;
   
    }
}
