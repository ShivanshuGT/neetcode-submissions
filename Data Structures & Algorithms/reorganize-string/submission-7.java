class QueueEntry{
    int freq;
    char ch;

    QueueEntry(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
    }


    private int getFrequency(){
        return this.freq;
    }

    private char getCh(){
        return this.ch;
    }
}
class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int t = 0;

        StringBuilder sb = new StringBuilder();

        Comparator<QueueEntry> comp = Comparator.comparingInt(QueueEntry::getFrequency).reversed();
                                

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comp);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            queue.add(new QueueEntry(entry.getValue(), entry.getKey()));
        }

        QueueEntry prev = null;

        while(!queue.isEmpty() || prev != null){

            if(prev != null && queue.isEmpty()){
                return "";
            }
            QueueEntry entry = queue.poll();
            char ch = entry.getCh();
            sb.append(ch);
            int freq = entry.getFrequency();

            if (prev != null){
                queue.add(prev);
                prev = null;
            }
            if(freq > 1){
                prev = new QueueEntry(freq-1, ch);
            }
        }
        return sb.toString();
        
        
    }
}