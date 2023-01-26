class Stop {
    int node, price;
    Stop(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Node {
    int node, stop, price;
    Node(int node, int stop, int price) {
        this.node = node;
        this.stop = stop;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Stop>> adj = new ArrayList();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        
        for(int[] flight: flights) {
            int s = flight[0], d = flight[1], price = flight[2];
            
            Stop stop = new Stop(d, price);
            adj.get(s).add(stop);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        
        Queue<Node> nodes = new LinkedList();
        nodes.add(new Node(src, 0, 0));
        
        while(!nodes.isEmpty()) {
            Node curr = nodes.poll();
            int currNode = curr.node;
            int currStop = curr.stop;
            int currDist = curr.price;
                        
            if(currStop > k) {
                break;
            }
            
            for(Stop stop: adj.get(currNode)) {
                int nextNode = stop.node;
                int nextPrice = stop.price;
                
                if(dist[nextNode] > currDist + nextPrice) {
                    dist[nextNode] = currDist + nextPrice;
                    Node next = new Node(nextNode, currStop+1, dist[nextNode]);
                    nodes.add(next);
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
} 