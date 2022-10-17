class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty == null || jobDifficulty.length == 0) {
            return -1;
        }
        
        int n = jobDifficulty.length;
        
        // You have more days than jobs
        if(d > n) {
            return -1;
        }
        
        // When the day is 1, there's only 1 way to do jobs
        // Do all the remaining tasks and then return the maximum of all
        int[][] dp = new int[n+1][d+1];
        
        // If on day 1 you choose to to 0th job, max diff is 0, 
        // If you choose 0 and 1st job, maxDiff = max(job[0], job[1])
        // If you choose 0,1,..j then maxDiff = max(j[0], job[1], .., job[j])
        // int maxSoFar = 0;
         for(int i = 0; i<=n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int max = 0;
        for(int i = n-1; i>=0; i--) {
            max = dp[i][1] = Math.max(max, jobDifficulty[i]);
        }
        
       
        
        // On other days, if you do jobs j, on day "day"then the value is the 
        // The work done of dp[j-1][day-1] (j-1), because j-1 work was done before
        // +
        // Need to consider for the same day if more work was done
        // dp[j][day] = min(
        // max(dp[j-1][day-1] + job[j])
        // doing 1 job on jth day, doing 2 jobs on jth day, doing k jobs on jth day
        // The min of all of this
       
        for(int day = 2; day<=d; day++) {
            for(int i = 0; i <= n-day; i++) {
                max = 0;
                int min = dp[i][day];
                for(int j = i; j <= n - day; j++) {
                    max = Math.max(max, jobDifficulty[j]);
                    dp[i][day]  = Math.min(dp[i][day], max + dp[j + 1][day - 1]);
                }
            }
        }
        
        return dp[0][d];
    }
}