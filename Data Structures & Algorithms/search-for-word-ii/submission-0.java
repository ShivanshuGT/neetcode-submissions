class Node{
    private Node links[];
    private boolean flag;
    private String word;

    Node(){
        this.links = new Node[26];
        this.flag = false;
        this.word = null;
    }

    boolean containsKey(char ch){
        return this.links[ch - 'a'] != null;
    }

    Node getKey(char ch){
        return this.links[ch - 'a'];
    }

    void setKey(char ch){
        this.links[ch - 'a'] = new Node();
    }

    boolean isLast(){
        return this.flag;
    }

    void setLast(){
        this.flag = true;
    }

    void unsetLast(){
        this.flag = false;
    }

    String getWord(){
        return this.word;
    }

    void setWord(String word){
        this.word = word;
    }
}

class Solution {

    private Node root = new Node();
    private List<String> ans = new ArrayList<>();

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void insertWordInTrie(String word){
        Node node = this.root;

        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.setKey(ch);
            }
            node = node.getKey(ch);
        }
        node.setLast();
        node.setWord(word);
    }

    private void findWordsHelper(char[][] board, int i, int j, Node node){

        int n = board.length;
        int m = board[0].length;

        // do bound check
        if(i < 0 || i >= n || j < 0 || j >= m){
            return;
        }

        if(board[i][j] == '*' || !node.containsKey(board[i][j])){
            return;
        }

        node = node.getKey(board[i][j]);

        if(node.isLast()){
            this.ans.add(node.getWord());
            node.unsetLast();
        }

        char temp = board[i][j];
        board[i][j] = '*';
        for(int[] dir : this.dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            findWordsHelper(board, row, col, node);
        }
        board[i][j] = temp;
    }


    public List<String> findWords(char[][] board, String[] words) {

        for(String word : words){
            this.insertWordInTrie(word);
        }

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = board[i][j];
                if(root.containsKey(ch)){
                    findWordsHelper(board, i, j, root);
                }
            }
        }

        return this.ans;


        
    }
}
