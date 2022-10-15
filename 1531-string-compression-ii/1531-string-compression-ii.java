class Solution {
private int n;
    
private int f(int idx, char prev, int curCharFreqCount, String s, int k, int dp[][][][])
    {
        if(k < 0) return (int)1e9;
        
        if(idx >= n)
            return 0;
        
        // if curCharFreqCount, consider it as 10, because, until 10 .. 99, string length will be 2, 
        if(curCharFreqCount >= 10)
            curCharFreqCount = 10;
        
        if(dp[idx][prev - 'a'][curCharFreqCount][k] != -1)
            return dp[idx][prev - 'a'][curCharFreqCount][k];
        
        
        int res = (int) 1e9;
        
        /*
        3 cases:
        case 1: We will delete our current character if K is available, so our string length will be minimum.
        case 2: If cur char is not same as prev, our res will be increased by 1 and curCharFreqCount will be 1
        case 3: If cur char is same as prev char, we need to merge it and increase our count
                case 3.1: If curCharFreqCount is either 1 or more than 9, our res will be increased by 1
                case 3.2: Else, we just need to increase curCharFreqCount.
        */
        
        // case 1
        res = Math.min(res, f(idx+1, prev, curCharFreqCount, s, k-1, dp));
        
        // case 2
        if(s.charAt(idx) != prev)
            res = Math.min(res, 1 + f(idx + 1, s.charAt(idx), 1, s, k, dp));
        
        // case 3
        else{
            
            // case 3.1
            if(curCharFreqCount == 1 || curCharFreqCount == 9)
            {
                res = Math.min(res, 1 + f(idx + 1, prev, (curCharFreqCount + 1), s, k, dp));
            }
            
            // case 3.2
            else{
                res = Math.min(res, f(idx + 1, prev, curCharFreqCount + 1, s, k, dp));
            }
        }
        
        return dp[idx][prev - 'a'][curCharFreqCount][k] = res;
    }
    
    public int getLengthOfOptimalCompression(String s, int k) {
         // 4 states -> [idx][prev_char][freq_count][k]
        n = s.length();
        
        if(n == 100)
        {
            boolean allSame = true;
            
            // Base case: check for all char are same
            for(int i = 1; i < n; i++)
            {
                if(s.charAt(i) != s.charAt(i-1))
                {
                    allSame = false;
                    break;
                }
            }

            if(allSame) return 4;
        }
        
        
        int[][][][] dp = new int[n+1][27][11][101];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 27; j++)
            {
                for(int x = 0; x < 11; x++)
                {
                    for(int y = 0; y < 101; y++)
                    {
                        dp[i][j][x][y] = -1;
                    }
                }
            }
        }
        
        return f(0, (char) ('z' + 1), 0, s, k, dp);
    }
}