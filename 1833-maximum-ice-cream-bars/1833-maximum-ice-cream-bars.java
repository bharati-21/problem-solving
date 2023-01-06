class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if(costs == null || costs.length == 0 || coins == 0) return 0;
        
        int numIceCreams = 0;
        Arrays.sort(costs);
        
        for(int cost: costs) {
            // can no longer buy any ice-creams
            if(cost > coins) break;
            numIceCreams++;
            coins-=cost;
        }
        
        return numIceCreams;
    }
}