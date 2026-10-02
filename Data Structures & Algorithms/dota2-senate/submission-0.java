class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();

        int activeR = 0;
        int activeD = 0;

        int skipR = 0;
        int skipD = 0;

        for(char c : senate.toCharArray()){
            if('R' == c){
                activeR += 1;
            }else{
                activeD += 1;
            }
            queue.add(c);
        }

        while(activeR > 0 && activeD > 0 ){
            char c = queue.poll();

            if('R' == c){
                if(skipR > 0){
                    skipR -= 1;
                    continue;
                }
                activeD -= 1;
                skipD += 1;
            }else{
                if(skipD > 0){
                    skipD -= 1;
                    continue;
                }
                activeR -= 1;
                skipR += 1;

            }
            queue.add(c);
            
        }

        return activeR > 0 ? "Radiant" : "Dire";
        
    }
}