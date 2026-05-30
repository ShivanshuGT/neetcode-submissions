class Node{
    private Node[] links;
    private boolean flag;

    Node(){
        this.links = new Node[26];
        this.flag = false;
    }

    Node getKey(char ch){
        return this.links[ch - 'a'];
    }

    void setKey(char ch){
        this.links[ch - 'a'] = new Node();
    }

    boolean containsKey(char ch){
        return this.links[ch - 'a'] != null;
    }

    boolean isLast(){
        return this.flag;
    }

    void setLast(){
        this.flag = true;
    }

    List<Node> getAllKeys(){
        List<Node> ans = new ArrayList<>();
        for(Node node : links){
            if(node != null){
                ans.add(node);
            }
        }
        return ans;
    }
}
class WordDictionary {

    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = this.root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.setKey(ch);
            }
            node = node.getKey(ch);
        }
        node.setLast();
    }

    private boolean searchHelper(String word, Node startNode){
        Node node = startNode;
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            if('.' == ch){
                List<Node> allKeys = node.getAllKeys();
                for(Node key : allKeys){
                    if(searchHelper(word.substring(i+1),key)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.getKey(ch);
            }
        }
        return node.isLast();
    }

    public boolean search(String word) {
        Node node = this.root;
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            if('.' == ch){
                List<Node> allKeys = node.getAllKeys();
                for(Node key : allKeys){
                    if(searchHelper(word.substring(i+1),key)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.getKey(ch);
            }
        }
        return node.isLast();

    }
}
