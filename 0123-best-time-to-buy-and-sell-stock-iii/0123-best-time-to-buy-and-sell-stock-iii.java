class Solution {
    int maxProfit = 0;
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        
        // At index i, you are buying or selling with 2/1/0 transactions left, then
        // What is the max profit at that point?
        int[][][] dp = new int[n+1][2][3];
        
        // All the choices for the last indices are 0
        
        for(int i = n-1; i>=0; i--) {
            for(int j = 0; j<=1; j++) {
                for(int t = 1; t<=2; t++) {
                    if(j == 0) {
                        // you sell today
                        dp[i][j][t] = Math.max(prices[i] + dp[i+1][j+1][t-1], dp[i+1][j][t]);
                    }
                    else {
                        // buy now
                        dp[i][j][t] = Math.max(-prices[i] + dp[i+1][j-1][t], dp[i+1][j][t]);
                    }
                }
            }
        }
        
        return dp[0][1][2];
        // return maxProfitHelper(prices, 0, 1, 2, n, memo);
    }
    
    private int maxProfitHelper(int[] prices, int i, int canBuy, int transactions, int n, int[][][] memo) {
        if(i == n) {
            return 0;
        }
        
        // If you don't have any more 
        // transactions left, then return 0
        if(canBuy == 1 && transactions == 0) {
            return 0;
        }
        
        if(memo[i][canBuy][transactions] != -1) {
            return memo[i][canBuy][transactions];
        }
        
        int price = prices[i];

        // This means you can buy now
        if(canBuy == 1) {
            // buy now or buy next
            int buyNow = -price + maxProfitHelper(prices, i+1, 0, transactions, n, memo);
            int buyNext = maxProfitHelper(prices, i+1, canBuy, transactions, n, memo);
            
            return memo[i][canBuy][transactions] = Math.max(buyNow, buyNext);
        }
        
        // You can only sell today and move to next day to buy
        // or sell the next day
        int sellNext = maxProfitHelper(prices, i+1, canBuy, transactions, n, memo);
        int sellNowBuyNext = price + maxProfitHelper(prices, i+1, 1, transactions-1, n, memo);

        return memo[i][canBuy][transactions] = Math.max(sellNext, sellNowBuyNext);
    }
}