class Solution {
    private Set<String> set;
    private int n;
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet();
        for(String word: wordDict) {
            set.add(word);
        }
        
        n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        return wordBreakHelper(s, 0);
    }
    
    private boolean wordBreakHelper(String s, int i) {
        if(i >= n) {
            return true;
        }
        
        if(memo[i] != -1) {
            return (memo[i] == 0) ? false : true;
        }
        
        for(int j = i+1; j<=s.length(); j++) {
            String currWord = s.substring(i,j);
            if(set.contains(currWord)) {
                boolean containsNextWord = wordBreakHelper(s, j);
                if(containsNextWord) {
                    memo[i] = 1;
                    return true;
                }
            }        
        }
        
        memo[i] = 0;
        return false;
    }
}