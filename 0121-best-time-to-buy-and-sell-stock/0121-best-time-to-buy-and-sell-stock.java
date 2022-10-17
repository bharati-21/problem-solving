class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int prevStock = prices[0];
        int n = prices.length;
        for(int i = 1; i<n; i++) {
            int price = prices[i];
            // either start from index i, or sell previous stock at index i
            
            // you already have a stock bought
            // then you can sell here or you can buy here
                if(price < prevStock) {
                    // then buy now
                    prevStock = price;
                }
                else {
                    profit = Math.max(profit, (price - prevStock));
                }
            
        }
        
        return profit;
    }
}