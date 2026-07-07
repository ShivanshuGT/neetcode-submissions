class Pair{
    int nodeValue;
    int weight;

    Pair(int nodeValue, int weight){
        this.nodeValue = nodeValue;
        this.weight = weight;
    }
}

class QueueEntry{
    int distance;
    int nodeValue;

    QueueEntry(int distance, int nodeValue){
        this.distance = distance;
        this.nodeValue = nodeValue;
    }
}
class Solution {

    public List<List<Pair>> buildGraph(int nodes, int[][] edges){
        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0; i <= nodes; i++){
            graph.add(new ArrayList<>());
        }

        int e = edges.length;

        for(int i = 0; i < e; i++){
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        return graph;
    }

    public int[] findMinimumDistancesFromSourceNode(List<List<Pair>> graph, int nodes, int sourceNode){
        int[] ans = new int[nodes+1];

        for(int i = 0; i <= nodes; i++){
            ans[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(Comparator.comparingInt((QueueEntry entry) -> entry.distance).thenComparing(entry -> entry.nodeValue));

        ans[sourceNode] = 0;

        queue.add(new QueueEntry(0, sourceNode));

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();

            int node = entry.nodeValue;
            int distance = entry.distance;

            List<Pair> neighbours = graph.get(node);

            for(Pair neighbour : neighbours){
                if(ans[neighbour.nodeValue] > distance + neighbour.weight){
                    ans[neighbour.nodeValue] = distance + neighbour.weight;
                    queue.add(new QueueEntry(ans[neighbour.nodeValue], neighbour.nodeValue));
                }
            }
        }

        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = buildGraph(n, times);
        int[] shortestDistance = findMinimumDistancesFromSourceNode(graph, n, k);
        int ans = -1;
        for(int i = 1; i <= n; i++){
            if(shortestDistance[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, shortestDistance[i]);
        }
        return ans;
    }
}
