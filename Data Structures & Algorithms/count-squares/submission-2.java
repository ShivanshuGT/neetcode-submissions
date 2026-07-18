class CountSquares {

    Map<Integer, List<List<Integer>>> xMap;
    Map<Integer, List<List<Integer>>> yMap;
    Map<String, Integer> map;

    private int getDistance(int[] p1, List<Integer> p2){
        return Math.abs(p1[0] - p2.get(0)) + Math.abs(p1[1] - p2.get(1));
    }

    public CountSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        List<List<Integer>> xList = xMap.getOrDefault(x, new ArrayList<>());
        xList.add(List.of(x, y));
        List<List<Integer>> yList = yMap.getOrDefault(y, new ArrayList<>());
        yList.add(List.of(x, y));
        xMap.put(x, xList);
        yMap.put(y, yList);
        StringBuilder key = new StringBuilder();
        key.append((char) (x + '0'));
        key.append((char) (y + '0'));
        map.put(key.toString(), map.getOrDefault(key.toString(), 0)+1);
    }
    
    public int count(int[] query) {
        int x = query[0];
        int y = query[1];

        List<List<Integer>> xPoints = xMap.get(x);
        List<List<Integer>> yPoints = yMap.get(y);
        if(xPoints == null || yPoints == null){
            return 0;
        }

        int ans = 0;

        for(List<Integer> xPoint : xPoints){
            int distance = getDistance(query, xPoint);
            if(distance == 0){
                continue;
            }
            for(List<Integer> yPoint : yPoints){
                if(getDistance(query, yPoint) == distance){
                    int fourthPointY = xPoint.get(1);
                    int fourthPointX = yPoint.get(0);
                    StringBuilder key = new StringBuilder();
                    key.append((char) (fourthPointX + '0'));
                    key.append((char) (fourthPointY + '0'));

                    if(map.containsKey(key.toString())){
                        ans += map.get(key.toString());
                    }
                }
            }
        }
        return ans;
        
    }
}
