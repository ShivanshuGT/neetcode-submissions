class QueueEntry{
    int idx;
    int enterTime;
    int processTime;

    QueueEntry(int idx, int enterTime, int processTime){
        this.idx = idx;
        this.enterTime = enterTime;
        this.processTime = processTime;
    }

    public int getIdx(){
        return this.idx;
    }

    public int getEnterTime(){
        return this.enterTime;
    }

    public int getProcessTime(){
        return this.processTime;
    }
}
class Solution {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Comparator<QueueEntry> comp1 = Comparator.comparingInt(QueueEntry::getEnterTime);
        Comparator<QueueEntry> comp2 = Comparator.comparingInt(QueueEntry::getProcessTime).
                                                thenComparingInt(QueueEntry::getIdx);

        List<QueueEntry> ls = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ls.add(new QueueEntry(i, tasks[i][0], tasks[i][1]));
        }

        Collections.sort(ls, comp1);

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comp2);

        int[] ans = new int[n];
        int x = 0;
        int t = 0;
        int i = 0;
        
        while(i < n || !queue.isEmpty()){
            if(queue.isEmpty() && t < ls.get(i).getEnterTime()){
                t = ls.get(i).getEnterTime();
            }

            while(i < n && t >= ls.get(i).getEnterTime()){
                queue.add(ls.get(i));
                i += 1;
            }

            QueueEntry entry = queue.poll();
            t += entry.getProcessTime();
            ans[x] = entry.getIdx();
            x += 1;
        }
        return ans;
        
    }
}