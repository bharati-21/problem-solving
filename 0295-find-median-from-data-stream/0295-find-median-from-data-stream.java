class MedianFinder {
    PriorityQueue<Integer> smallHeap, largeHeap;
    
    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(!largeHeap.isEmpty() && !smallHeap.isEmpty()) {
            if(smallHeap.peek() > largeHeap.peek()) {
                largeHeap.add(smallHeap.poll());
            }
        }
        
        if(smallHeap.size() - largeHeap.size() > 1) {
            largeHeap.add(smallHeap.poll());
        }
         
        if(largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(largeHeap.size() > smallHeap.size()) {
            return largeHeap.peek();
        }
        if(smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        }
        
        double first = smallHeap.peek();
        double second = largeHeap.peek();
        return (first + second)/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */