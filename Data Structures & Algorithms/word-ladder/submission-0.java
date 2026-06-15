class QueueEntry{
    int length;
    String word;

    QueueEntry(int length, String word){
        this.word = word;
        this.length = length;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        Set<String> words = new HashSet<>();
        for(String w : wordList){
            words.add(w);
        }

        int m = beginWord.length();

        Queue<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(1, beginWord));

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();

            if(endWord.equals(entry.word)){
                return entry.length;
            }

            for(int i = 0; i < m; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    String word = entry.word;

                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String formedWord = new String(wordArray);

                    if(words.contains(formedWord)){
                        queue.add(new QueueEntry(entry.length + 1, formedWord));
                        words.remove(formedWord);
                    }

                }
            }

            
        }
        return 0;
    }
}
