class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n][amount+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        int ans = coinChangeHelper(n-1, coins, amount, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int coinChangeHelper(int i, int[] coins, int amount, int[][] memo) {
        if(i == 0) {
            int c = coins[0];
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
