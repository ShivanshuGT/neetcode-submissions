class Node{
    private Node[] links;
    private boolean flag;

    Node(){
        this.links = new Node[26];
        this.flag = false;
    } 

    boolean containsKey(char ch){
        return this.links[ch - 'a'] != null;
    }

    boolean isLast(){
        return this.flag;
    }

    void setKey(char ch){
        this.links[ch - 'a'] = new Node();
    }

    Node getKey(char ch){
        return this.links[ch - 'a'];
    }

    void setLast(){
        this.flag = true;
    }
}

class PrefixTree {

    private Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = this.root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.setKey(ch);
            }
            node = node.getKey(ch);
        }
        node.setLast();
    }

    public boolean search(String word) {
        Node node = this.root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.getKey(ch);
        }
        return node.isLast();
    }

    public boolean startsWith(String prefix) {
        Node node = this.root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.getKey(ch);
        }
        return true;
    }
}
