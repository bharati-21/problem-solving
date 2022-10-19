class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];
        
        return maxProfitHelper(prices, 0, 1, n, memo);
    }
    
    private int maxProfitHelper(int[] prices, int i, int canBuy, int n, Integer[][] memo) {
        if(i == n) {
            return 0;
        }
        
        if(memo[i][canBuy] != null) {
            return memo[i][canBuy];
        }
        
        int price = prices[i];

        // This means you can buy now
        if(canBuy == 1) {
            // buy now
            int buyNow = -price + maxProfitHelper(prices, i+1, 0, n, memo);
            int buyNext = maxProfitHelper(prices, i+1, canBuy, n, memo);
            
            // The max of either buying today or buying tomorrow
            return memo[i][canBuy] = Math.max(buyNow, buyNext);
        }
        
        // You can only sell today
        int sellNext = maxProfitHelper(prices, i+1, canBuy, n, memo);
        int buyNext = price + maxProfitHelper(prices, i+1, 1, n, memo);
        
        return memo[i][canBuy] = Math.max(buyNext, sellNext);
    }
}