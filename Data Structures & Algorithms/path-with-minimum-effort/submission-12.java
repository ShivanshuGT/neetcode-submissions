class QueueEntry{
    int effort;
    int row;
    int col;

    QueueEntry(int row, int col, int effort){
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

    public int getEffort(){
        return this.effort;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {

        Comparator<QueueEntry> comp = Comparator.comparingInt(QueueEntry::getEffort).thenComparing(QueueEntry::getRow).
                                        thenComparing(QueueEntry::getCol);

        Queue<QueueEntry> queue = new PriorityQueue<>(comp);

        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.add(new QueueEntry(0, 0, 0));

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            int row = entry.row;
            int col = entry.col;
            int effort = entry.effort;

            if(row == n-1 && col == m-1){
                return effort;
            }

            for(int[] dir : dirs){
                int i = row + dir[0];
                int j = col + dir[1];

                if(i >= 0 && j >= 0 && i < n && j < m){
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[i][j]));

                    if(newEffort < distance[i][j]){
                        distance[i][j] = newEffort;
                        queue.add(new QueueEntry(i, j, newEffort));
                    }
                }

                
            }

        }

        return -1;
        
    }
}