class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        
        // int[][] dp = new int[n+1][2];
        // dp[n][0] = 0;
        // dp[n][1] = 0; 
        int[] curr = new int[2];
        int[] prev = new int[2];
        // you cannot sell anything on day 1
        // you can buy the stock 1 on day 1
        for(int i = n-1; i>=0; i--) {
            for(int j = 1; j>=0; j--) {
                if(j == 0) {
                    // sell here
                    curr[j] = Math.max(prices[i] + prev[1], prev[0]);
                }
                else {
                    // buy here
                    curr[j] = Math.max(-prices[i] + curr[0], prev[1]);
                }
            }
            
            prev = curr;
        }
        
        return prev[1];
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

/*
f(0,1)
 => -7 + f(1,0)
        => 1 + f(2,1)
            => -5 + f(3,0)
                => 

*/