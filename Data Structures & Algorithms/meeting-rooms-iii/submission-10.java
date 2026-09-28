class QueueEntry{
    int time;
    int id;

    QueueEntry(int id, int time){
        this.id = id;
        this.time = time;
    }

    public int getId(){
        return this.id;
    }

    public int getTime(){
        return this.time;
    }
}
class Solution {

    
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        Comparator<QueueEntry> comp1 = Comparator.comparingInt(QueueEntry::getId);

        Comparator<QueueEntry> comp2 = Comparator.comparingInt(QueueEntry::getTime).
                                        thenComparing(QueueEntry::getId);
        Queue<QueueEntry> availableRooms = new PriorityQueue<>(comp1);
        Queue<QueueEntry> usedRooms = new PriorityQueue<>(comp2);

        for(int i = 0; i < n; i++){
            availableRooms.add(new QueueEntry(i, 0));
        }
        int[] counter = new int[n];

        int m = meetings.length;

        for(int i = 0; i < m; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end - start;
            
            while(!usedRooms.isEmpty() && usedRooms.peek().time <= start){
                int room = usedRooms.poll().id;
                availableRooms.add(new QueueEntry(room, 0));
            }

            if(!availableRooms.isEmpty()){
                int room = availableRooms.poll().id;
                counter[room] += 1;
                usedRooms.add(new QueueEntry(room, end));
            }else{
                // delay the meeting
                QueueEntry roomEntry = usedRooms.poll();
                counter[roomEntry.id] += 1;
                usedRooms.add(new QueueEntry(roomEntry.id, roomEntry.time + duration));
            }


        }

        int maxValue = 0;
        int ans = -1;

        for(int i = 0; i < n; i++){
            if(counter[i] > maxValue){
                maxValue = counter[i];
                ans = i;
            }
        }
        return ans;
        
    }
}