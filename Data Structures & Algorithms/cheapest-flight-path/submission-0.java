class Pair{
    int nodeValue;
    int weight;

    Pair(int nodeValue, int weight){
        this.nodeValue = nodeValue;
        this.weight = weight;
    }
}

class QueueEntry{
    int fare;
    int node;
    int stops;

    QueueEntry(int node, int stops, int fare){
        this.node = node;
        this.stops = stops;
        this.fare = fare;
    }
}
class Solution {

    private List<List<Pair>> buildGraph(int n, int[][] flights){
        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int m = flights.length;

        for(int i = 0; i< m; i++){
            int[] flight = flights[i];
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> graph = buildGraph(n, flights);

        int[] fare = new int[n];

        for(int i = 0; i < n; i++){
            fare[i] = Integer.MAX_VALUE;
        }

        fare[src] = 0;

        Queue<QueueEntry> queue = new LinkedList<>();

        queue.add(new QueueEntry(src, 0, 0));

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            int node = entry.node;
            int currentStops = entry.stops;
            int currentFare = entry.fare;

            if(node == dst){
                continue;
            }

            List<Pair> neighbors = graph.get(node);

            for(Pair neighbor : neighbors){
                if(fare[neighbor.nodeValue] > currentFare + neighbor.weight && currentStops <= k){
                    fare[neighbor.nodeValue] = currentFare + neighbor.weight;
                    queue.add(new QueueEntry(neighbor.nodeValue, currentStops+1, fare[neighbor.nodeValue]));
                }
            }
        }

        return fare[dst] == Integer.MAX_VALUE ? -1 : fare[dst];

    }
}
