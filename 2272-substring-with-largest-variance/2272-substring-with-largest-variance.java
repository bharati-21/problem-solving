class Solution {
    public int largestVariance(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int maxVariance = 0;
        int n = s.length();
        
        Set<Character> set = new HashSet();
        for(int i = 0; i<n; i++) {
            set.add(s.charAt(i));
        }
        
        for(char a: set) {
            for(char b: set) {
                if(a == b) {
                    continue;
                }
                int variance = kadanes(a, b, s);
                maxVariance = Math.max(variance, maxVariance);
            }
        }
        
        
        return maxVariance;
    }
    
    private int kadanes(char a, char b, String s) {
        int variance = 0, var = 0;
        
        boolean hasB = false;
        boolean firstB = false;
        
        for(char ch: s.toCharArray()) {
            if(ch == a) {
                var++;
            }
            else if(ch == b) {
                hasB = true;
                // If we have something like this baab, then baab will not give max value
                // rather aab wil give. Hence we shift by one right 
                if(firstB && var >= 0) {
                    firstB = false;
                }
                // If we have something like aabbb
                // then we begin a new window with b as start
                // the variance remains -1
                else if((var - 1) < 0) {
                    firstB = true;
                    var = -1;
                }
                else {
                    var--;
                }
            }

            if(hasB) {
                variance = Math.max(var, variance);
            }
        }
        
        return variance;
    }
}
