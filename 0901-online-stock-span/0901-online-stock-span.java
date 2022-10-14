class Pair {
    int price, index;
    Pair(int price, int index) {
        this.price = price;
        this.index = index;
    }
}

class StockSpanner {
    int index = 0;
    Deque<Pair> stocks;
    public StockSpanner() {
        stocks = new ArrayDeque();
    }
    
    public int next(int price) {
        while(!stocks.isEmpty()) {
            if(price >= stocks.peek().price) {
                stocks.pop();
            }
            else {
                break;
            }
        }
        int span = 1 + index - (stocks.isEmpty() ? 0 : (stocks.peek().index+1));
        stocks.push(new Pair(price, index));
        index++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
