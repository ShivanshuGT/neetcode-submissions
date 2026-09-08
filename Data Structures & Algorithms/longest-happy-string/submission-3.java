class QueueEntry{
    int freq;
    char ch;

    QueueEntry(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    public char getCh(){
        return this.ch;
    }

    public int getFrequency(){
        return this.freq;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {

        Comparator<QueueEntry> comp = Comparator.comparingInt(QueueEntry::getFrequency).reversed();

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comp);

        if(a > 0) queue.add(new QueueEntry('a', a));
        if(b > 0) queue.add(new QueueEntry('b', b));
        if(c > 0) queue.add(new QueueEntry('c', c));


        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            char ch = entry.getCh();
            int freq = entry.getFrequency();

            if (sb.length() >= 2 && (sb.charAt(sb.length()-1) == ch) && (sb.charAt(sb.length()-2) == ch)){
                // we cant add ch to ans
                if(queue.isEmpty()){
                    break;
                }else{
                    QueueEntry entrys = queue.poll();
                    char chs = entrys.getCh();
                    int freqs = entrys.getFrequency();
                    sb.append(chs);
                    if(freqs > 1){
                        queue.add(new QueueEntry(chs, freqs-1));
                    }
                }
            }else{
                // we can add ch to ans
                sb.append(ch);
                freq -= 1;
            }

            if(freq >= 1){
                queue.add(new QueueEntry(ch, freq));
            }

            
        }
        return sb.toString();
        
    }
}