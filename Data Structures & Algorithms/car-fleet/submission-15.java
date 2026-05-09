class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = position.length;
        for(int i = 0; i < n; i++){
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        int ans = 1;
        double time = 0;
        time = (double)(target - position[n-1])/(map.get(position[n-1]));
        System.out.println("time " + time);
        for(int i = n-2; i >= 0; i--){
            int sp = map.get(position[i]);
            double pos = (double)position[i] + (double)(time * sp);
            System.out.println("pos = " + pos);
            if(pos >= target){
                continue;
            }else{
                ans += 1;
                time = (double)(target - position[i])/(map.get(position[i]));
                System.out.println("time = " + time);
            }
                
        }
        return ans;
    }
}
