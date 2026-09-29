class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int bill : bills){
            if(bill == 5){
                map.put(5, map.getOrDefault(5, 0) + 1);
            }else if(bill == 10){
                if(map.containsKey(5)){
                    int freq = map.get(5);
                    if(freq > 1){
                        map.put(5, freq-1);
                    }else{
                        map.remove(5);
                    }
                    map.put(10, map.getOrDefault(10, 0) + 1);

                }else{  
                    return false;
                }
            }else{
                int five = map.getOrDefault(5, 0);
                int ten = map.getOrDefault(10, 0);

                if(five >= 1 && ten >= 1){
                    five -= 1;
                    ten -= 1;

                    if(five > 0){
                        map.put(5, five);
                    }else{
                        map.remove(5);
                    }

                    if(ten > 0){
                        map.put(10, ten);
                    }else{
                        map.remove(10);
                    }
                    map.put(20, map.getOrDefault(20, 0) + 1);
                }else if(five >= 3){
                    five -= 3;
                    if(five > 0){
                        map.put(5, five);
                    }else{
                        map.remove(5);
                    }
                    map.put(20, map.getOrDefault(20, 0) + 1);

                }else{
                    return false;
                }

            }
        }
        return true;
        
    }
}