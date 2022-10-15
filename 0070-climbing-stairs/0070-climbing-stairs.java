class Solution {
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] memoization = new int[n+1];
        Arrays.fill(memoization, -1);
        
        return climbStairsMemoization(n, memoization);
    }
    
    private int climbStairsMemoization(int n, int[] memoization) {
        if(n <= 2) {
            return n;
        }
        
        if(memoization[n] != -1) {
            return memoization[n];
        }
        
        int takeOneStep = climbStairsMemoization(n-1, memoization);
        int takeTwoSteps = climbStairsMemoization(n-2, memoization);
        memoization[n] = takeOneStep + takeTwoSteps;
        
        return memoization[n];
    }
}

/*
n = 1 => only 1 way to climb step 1
n = 2 => you can climb 1 + 1 or (2) steps
n = 3 => you can climb 1 step + 1 step + 1 step or 1 step + 2 step or 2step + 1step
n = 4 => you can climb 
    1 + 1 + 1 + 1, 
    1 + 2 + 1, 
    2 + 1 + 1, 
    1 + 1 + 2, 
    2 + 2
n = 5 => you can climn 
    1 + 1 + 1 + 1 + 1
    1 + 1 + 1 + 2
    1 + 2 + 1 + 1
    2 + 1 + 1 + 1
    1 + 1 + 2 + 1
    1 + 2 + 2
    2 + 2 + 1
    2 + 1 + 2
n = 6 
    1 + 1 + 1 + 1 + 1 + 1
    1 + 1 + 1 + 1 + 2
    1 + 1 + 1 + 2 + 1
    1 + 1 + 2 + 1 + 1
    1 + 2 + 1 + 1 + 1
    2 + 1 + 1 + 1 + 1
    2 + 2 + 1 + 1
    2 + 1 + 2 + 1
    2 + 1 + 1 + 2
    1 + 2 + 2 + 1
    1 + 2 + 1 + 2
    1 + 1 + 2 + 2
    2 + 2 + 2 
*/