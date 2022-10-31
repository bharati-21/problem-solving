class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        
        for(int i = 0; i<=amount; i++) {
            int c = coins[0];
            if(i % c == 0) {
                prev[i] = i/c;
            }
            else {
                prev[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 1; i<n; i++) {
            int[] curr = new int[amount+1];
            for(int j = 0; j<=amount; j++) {
                int c = coins[i];
                int take = Integer.MAX_VALUE;
                
                if(j >= c) {
                    int p = curr[j-c];
                    if(p != Integer.MAX_VALUE) {
                        p += 1;
                    }
                    take = p;
                }
                
                int notTake = prev[j];
                curr[j] = Math.min(take, notTake);
            }
            
            prev = curr;
        }
        
        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }
    
    private int coinChangeHelper(int i, int[] coins, int amount, int[][] memo) {
        if(i == 0) {
            int c = coins[0];
            // amount can be anything from 0 to amount
            if(amount % c != 0) {
                return Integer.MAX_VALUE;
            }
            int numCoins = amount / c;
            return numCoins;
        }
        
        if(memo[i][amount] != -1) {
            return memo[i][amount];
        }
        
        int c = coins[i];
        int pick = Integer.MAX_VALUE;
        
        if(amount >= c) {
            pick = coinChangeHelper(i, coins, amount-c, memo);
            if(pick != Integer.MAX_VALUE) {
                pick += 1;
            }
        }
        
        int notPick = coinChangeHelper(i-1, coins, amount, memo);
        
        return memo[i][amount] = Math.min(pick, notPick);
    }
}

// f(2, 11)
// pick = 2 + f(1, 1)
