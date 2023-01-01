class Tuple {
    int node, stops, price;
    
    Tuple(int node, int stops, int price) {
        this.node = node;
        this.stops = stops;
        this.price = price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        
        List<List<int[]>> adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
        }
        
        for(int[] flight: flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            adj.get(from).add(new int[] {
                to, price
            });
        }
        
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        Queue<Tuple> path = new LinkedList();
        path.add(new Tuple(src, 0, 0));
        
        while(!path.isEmpty()) {
            Tuple currTuple = path.poll();
            int currNode = currTuple.node;
            int currPrice = currTuple.price;
            int currStops = currTuple.stops;
            
            for(int[] next: adj.get(currNode)) {
                int nextNode = next[0];
                int nextPrice = next[1] + currPrice;
                int nextStops = currStops + 1;
                
                if(currStops == k && nextNode != dst) {
                    continue;
                }
                
                if(nextPrice < prices[nextNode]) {
                    prices[nextNode] = nextPrice;
                    path.add(new Tuple(nextNode, nextStops, nextPrice));
                }
            }
        }
        
        if(prices[dst] == Integer.MAX_VALUE) return -1;
        
        return prices[dst];
    }
}