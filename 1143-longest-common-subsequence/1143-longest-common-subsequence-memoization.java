class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        
        int n = text1.length();
        int m = text2.length();
        
        int[][] memo = new int[n][m];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return lcsHelper(text1, text2, 0, 0, n, m, memo);
    }
    
    private int lcsHelper(String s, String t, int i, int j, int n, int m, int[][] memo) {
        if(i == n || j == m) {
            return 0;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        char sch = s.charAt(i);
        char tch = t.charAt(j);
        
        if(sch == tch) {
            return memo[i][j] = 1 + lcsHelper(s, t, i+1, j+1, n, m, memo);
        }
        
        int incrementI = lcsHelper(s, t, i+1, j, n, m, memo);
        int incrementJ = lcsHelper(s, t, i, j+1, n, m, memo);
        return memo[i][j] =  Math.max(incrementI, incrementJ);
    }
}

/*
- Generating all the possible subsequences is costly => exponential
- Hence we can check by common characters.
- We start with 0,0
    - if 0,0 match we increment both
    - if 0,0 don't match, we try 0,1 | 1,0
    - return the longest string

abcde 
abc
helper("abcde", "abc", 0, 0)
    s[0] == t[0]
    helper("abcde", "abc", 1, 1)
        s[1] != t[1]
        helper(abcde, abc, 1,2) 
            s[1] != t[2]
            helper(abcde, abc, 1,3)
                3 > m => return 0
            helper(abcde, abc, 2,2) => return 1
                s[2] != t[2]
                helper(abcde, abc, 2, 3)
                    3 >= n => return 0
                helper(abcde, abc, 3, 2) => return 1
                    s[3] != t[3]
                    helper(abcde, abc, 3, 3)
                        3 >= m => return 0
                    helper(abcde, abc, 4, 2)
                        s[3] == t[2] => return 1 + 0
        
        helper(abcde, abc, 2, 1)
            s[2] == s[1]
*/  
