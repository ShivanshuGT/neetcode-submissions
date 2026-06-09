class MedianFinder {

    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        this.leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(leftHeap.isEmpty() || num < leftHeap.peek()){
            leftHeap.add(num);
        }else{
            rightHeap.add(num);
        }

        if((leftHeap.size() - rightHeap.size()) > 1){
            rightHeap.add(leftHeap.poll());
        }else if(leftHeap.size() < rightHeap.size()){
            leftHeap.add(rightHeap.poll());
        }
        
    }
    
    public double findMedian() {
        int total = leftHeap.size() + rightHeap.size();
        if(total % 2 == 0){
            return (double)(leftHeap.peek() + rightHeap.peek())/ 2;
        }else{
            return leftHeap.peek();
        }
    }
}
