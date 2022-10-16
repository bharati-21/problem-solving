class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) {
            return -1;
        }
        
        int[][][] memo = new int[n+1][n+1][d+1];
        for(int[][] row1: memo) {
            for(int[] row: row1) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        return minDifficultyHelper(jobDifficulty, d, 0, n, memo);
    }
        
    // 
    private int minDifficultyHelper(int[] jobDifficulty, int d, int start, int end, int[][][] memo) {
        if(d == 1) {
            // return the max at this value from start to end
            return getMax(jobDifficulty, start, end-1);
        }
        
        if(memo[start][end][d] != Integer.MAX_VALUE) {
            return memo[start][end][d];
        }
        
        int minValue = memo[start][end][d];
        for(int i = start; i<=end-d; i++) {
            // This gets the values at the cut [i+1, end)
            int nextCut = minDifficultyHelper(jobDifficulty, d-1, i+1, end, memo);
            int currentCutMax = getMax(jobDifficulty, start, i);
                
            minValue = Math.min(minValue, (nextCut + currentCutMax));
            memo[start][i][d] = minValue;
        }
        
        return memo[start][end][d] = minValue;
    }
    
    private int getMax(int[] jobDifficulty, int i, int j) {
        int currentCutMax = 0;
        while(i <= j) {
            currentCutMax = Math.max(jobDifficulty[i], currentCutMax);
            i++;
        }
        
        return currentCutMax;
    }
}

/*
- schedule list of jobs in d days
- dependent. To finish ith job, have to complete all j jobs 0 <=j < i
- at least 1 task everyday
- Sum of difficulties of each of day 
- diff(day) => max diff of job on that day

6+5+4+3+2+1

6+5+4 => 6
3 => 3
2+1 => 2

6+5+4 => 6
3+2 => 3
1 => 1

6+5 => 6 
4+3 => 4
2+1 => 2

6+5 => 6
4+3+2 => 4
1 => 1

6 => 6
5+4 => 5
3+2+1 => 3

6 => 6
5+4+3 => 5
2+1 => 2

6 => 6
5+4 => 5
3+2+1 => 3

6+5+4+3 => 6
2 => 2
1 => 1

*/


/*
[5,1,8,2,3,6,7]
5+1+8 => 8
2+3+6 => 6
7 => 7

5 => 5
1 => 1
8,2,3,6,7 => 8

5+1
8+2+3+6
7
*/