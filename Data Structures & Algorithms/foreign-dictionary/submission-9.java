class Pair{
    int nodeValue;
    int weight;

    Pair(int nodeValue, int weight){
        this.nodeValue = nodeValue;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "" + this.nodeValue + "";
    }
}
class Solution {

    private Map<Integer, Integer> findDistinctCharacters(String[] words){
        Map<Integer, Integer> map = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!map.containsKey(ch - 'a')){
                    map.put(ch - 'a', 1);
                }
            }
        }
        return map;
    }

    private Map<Integer, List<Pair>> buildGraph(String[] words){
        Map<Integer, List<Pair>> graph = new HashMap<>();

        int n = words.length;

        for(int i = 0; i < n-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int j = 0;
            int n1 = word1.length();
            int n2 = word2.length();

            while(j < n1 && j < n2){
                if(word1.charAt(j) != word2.charAt(j)){
                    int source = word1.charAt(j) - 'a';
                    List<Pair> ls = graph.getOrDefault(source, new ArrayList<>());
                    ls.add(new Pair(word2.charAt(j) - 'a', 1));
                    graph.put(source, ls);
                    break;
                }
                j += 1;
            }
        }

        

        for(Map.Entry<Integer, Integer> entry : findDistinctCharacters(words).entrySet()){
            if(!graph.containsKey(entry.getKey())){
                graph.put(entry.getKey(), new ArrayList<>());
            }
        }
        return graph;
    }

    private String findPossibleSequence(String[] words){
        Map<Integer, List<Pair>> graph = buildGraph(words);
        System.out.println(graph);

        Map<Integer, Integer> indegree = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : findDistinctCharacters(words).entrySet()){
            indegree.put(entry.getKey(), 0);
        }

        for(Map.Entry<Integer, List<Pair>> entry : graph.entrySet()){
            List<Pair> edges = entry.getValue();

            for(Pair edge : edges){
                indegree.put(edge.nodeValue, indegree.get(edge.nodeValue) + 1);
            }
        }

        System.out.println("============INDGREE============");
        System.out.println(indegree);

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        StringBuilder ans = new StringBuilder();
        int topoLength = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.append((char) (node + 'a'));
            topoLength += 1;

            List<Pair> neighbors = graph.get(node);
            for(Pair neighbor : neighbors){
                indegree.put(neighbor.nodeValue, indegree.get(neighbor.nodeValue) - 1);
                if(indegree.get(neighbor.nodeValue) == 0){
                    queue.add(neighbor.nodeValue);
                }
            }

            

        }
        if(topoLength != graph.size()){
            return "";
        }
        return ans.toString();

    }

    private boolean checkForSubstringPossibility(String[] words){
        int n = words.length;

        for(int i = 0; i < n-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(!word1.equals(word2) && word1.contains(word2)){
                return false;
            }
        }
        return true;
    }
    public String foreignDictionary(String[] words) {
        if(!checkForSubstringPossibility(words)){
            System.out.println("mvnjfv");
            return "";
        }
        return findPossibleSequence(words);
      
    }
}
