class Pair{
    int nodeValue;
    int weight;

    Pair(int nodeValue, int weight){
        this.nodeValue = nodeValue;
        this.weight = weight;
    }
}

class QueueEntry{
    int weight;
    int node;
    int parent;

    QueueEntry(int weight, int node, int parent){
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

class MST{
    List<List<Integer>> edges;
    int sum;

    MST(List<List<Integer>> edges, int sum){
        this.edges = edges;
        this.sum = sum;
    }
}
class Solution {

    private static int getDistance(int[] point1, int[] point2){
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    private MST findMST(List<List<Pair>> graph){
        int n = graph.size();

        int[] visited = new int[n];

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(Comparator.comparingInt((QueueEntry e) -> e.weight).thenComparing(e -> e.node).thenComparing(e -> e.parent));

        queue.add(new QueueEntry(0, 0, -1));
        int sum = 0;
        List<List<Integer>> mstEdges = new ArrayList<>();

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            int node = entry.node;
            int weight = entry.weight;
            int parent = entry.parent;

            if(visited[node] == 1){
                continue;
            }

            visited[node] = 1;

            if(parent != -1){
                mstEdges.add(List.of(parent, node, weight));
                sum += weight;
            }

            List<Pair> neighbors = graph.get(node);

            for(Pair neighbor : neighbors){
                if(visited[neighbor.nodeValue] != 1){
                    queue.add(new QueueEntry(neighbor.weight, neighbor.nodeValue, node));
                }
            }
        }

        return new MST(mstEdges, sum);
    }

    private List<List<Pair>> buildGraph(int[][] points){
        int n = points.length;

        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                graph.get(i).add(new Pair(j, getDistance(points[i], points[j])));
            }
        }
        return graph;
    }


    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> graph = buildGraph(points);
        MST mst = findMST(graph);
        return mst.sum;
    }
}
