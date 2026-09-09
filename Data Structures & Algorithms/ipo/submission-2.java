class QueueEntry{
    int profit;
    int capital;
    int idx;

    QueueEntry(int idx, int profit, int capital){
        this.idx = idx;
        this.profit = profit;
        this.capital = capital;
    }

    public int getProfit(){
        return this.profit;
    }

    public int getCapital(){
        return this.capital;
    }

    public int getIdx(){
        return this.idx;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Comparator<QueueEntry> comp1 = Comparator.comparingInt(QueueEntry::getCapital);
        Comparator<QueueEntry> comp2 = Comparator.comparingInt(QueueEntry::getProfit).reversed();

        List<QueueEntry> ls = new ArrayList<>();

        int n = profits.length;

        for(int i = 0; i < n; i++){
            ls.add(new QueueEntry(i, profits[i], capital[i]));
        }

        Collections.sort(ls, comp1);

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comp2);

        int i = 0;
        int x = 0;



        while(i < n && x < k){

            if(i < n && queue.isEmpty() && w < ls.get(i).getCapital()){
                return w;
            }

            while(i < n && w >= ls.get(i).getCapital()){
                queue.add(ls.get(i));
                i += 1;
            }

            if(!queue.isEmpty()){
                QueueEntry entry = queue.poll();
                w += entry.getProfit();
                x += 1;
            }

        }

        while(!queue.isEmpty() && x < k){
            w += queue.poll().getProfit();
            x += 1;
        }
        return w;
        
    }
}