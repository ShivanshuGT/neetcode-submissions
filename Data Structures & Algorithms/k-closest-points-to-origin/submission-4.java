class Solution {

    private double getDistance(int[] point){
        return Math.sqrt(point[0]*point[0] + point[1]*point[1]);
    }


    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double da = getDistance(a);
            double db = getDistance(b);
            if(da < db){
                return 1;
            }else if(da > db){
                return -1;
            }else{
                return 0;
            }

        });

        

        for(int[] point : points){
            if(queue.size() < k){
                queue.add(point);
            }else{
                if(getDistance(queue.peek()) > getDistance(point)){
                    queue.poll();
                    queue.add(point); 
                }
            }
        }

        int[][] ans = new int[k][2];
        int x = 0;
        while(x < k){
            ans[x] = queue.poll(); 
            x += 1;
        }
        return ans;
    }
}
