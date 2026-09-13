class Solution {

    private String getNewStateInc(String state, int idx){
        char[] arr = state.toCharArray();
        int cur = arr[idx] - '0';
        int toBe = (cur + 1) % 10;
        arr[idx] = (char)('0' + toBe);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private String getNewStateDec(String state, int idx){
        char[] arr = state.toCharArray();
        int cur = arr[idx] - '0';
        int toBe = (cur - 1);
        if(toBe == -1){
            toBe = 9;
        }
        arr[idx] = (char)('0' + toBe);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private List<String> getNeighbors(String s){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            ans.add(getNewStateInc(s, i));
            ans.add(getNewStateDec(s, i));
        }
        return ans;
    }

    

    
    public int openLock(String[] deadends, String target) {
        Set<String> blocked = new HashSet<>();

        for(String s : deadends){
            blocked.add(s);
        }

        if(blocked.contains("0000")){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int ans = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size > 0){
                String node = queue.poll();
                if(node.equals(target)){
                    return ans;
                }
                List<String> neighbors = getNeighbors(node);
                for(String neighbor : neighbors){
                    if(!blocked.contains(neighbor)){
                        queue.add(neighbor);
                        blocked.add(neighbor);
                    }
                }
                size -= 1;
            }
            ans += 1;
        }

        return -1;


        
    }
}