class Solution {
    private Map<String, List<String>> adj;
    private int n;
    private List<String> itinerary;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap();
        itinerary = new ArrayList();
        n = tickets.size();
        
        for(List<String> ticket: tickets) {
            String dest = ticket.get(0);
            String arrival = ticket.get(1);
            
            if(!adj.containsKey(dest)) {
                adj.put(dest, new ArrayList());
            }
            adj.get(dest).add(arrival);
        }
        
        for(String dest: adj.keySet()) {
            Collections.sort(adj.get(dest));
        }
        
        itinerary.add("JFK");
        traverseTickets("JFK");
        return itinerary;
    }
    
    private boolean traverseTickets(String airport) { 
        // have included all airports
        if(itinerary.size() == n+1) {
            return true;
        }
        
        if(!adj.containsKey(airport)) {
            return false;
        }
        
        List<String> arrivals = new ArrayList(adj.get(airport));
        for(String arrival: arrivals) {
            // try visiting from this airport
            adj.get(airport).remove(arrival);
            itinerary.add(arrival);
            boolean isValid = traverseTickets(arrival);
            if(isValid) {
                return true;
            }
            adj.get(airport).add(arrival);
            itinerary.remove(itinerary.size()-1);
        }
        
        return false;
    }
}