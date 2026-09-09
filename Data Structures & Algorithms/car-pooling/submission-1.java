class QueueEntry{
    int time;
    int people;

    QueueEntry(int time, int people){
        this.time = time;
        this.people = people;
    }

    public int getTime(){
        return this.time;
    }

    public int getPeople(){
        return this.people;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int n = trips.length;

        Comparator<QueueEntry> comp = Comparator.comparingInt(QueueEntry::getTime).
                                        thenComparingInt(QueueEntry::getPeople);

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comp);

        for(int i = 0; i < n; i++){
            int[] trip = trips[i];
            queue.add(new QueueEntry(trip[1], trip[0]));
            queue.add(new QueueEntry(trip[2], -trip[0]));

        }

        int current = 0;
        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            current += entry.getPeople();
            if(current > capacity){
                return false;
            }
        }
        return true;
        
    }
}