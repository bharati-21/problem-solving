class Solution {
    public String largestNumber(int[] cost, int target) {
        if(cost == null || cost.length == 0) {
            return "0";
        }
        
        String[] memo = new String[target+1];
        
        return largestNumberHelper(cost, target, memo);
    }
    
    private String largestNumberHelper(int[] cost, int target, String[] memo) {
        if(target < 0) {
            return "0";
        }
        
        if(target == 0) {
            return "";
        }
        
        if(memo[target] != null) {
            return memo[target];
        }
        
        
        String largestNum = "0";
        for(int i = 0; i<cost.length; i++) {
            int nextTarget = target - cost[i];
            
            String nextNum = largestNumberHelper(cost, nextTarget, memo);
            if(nextNum.equals("0")) {
                continue;
            }
            String currNum = (i+1) + nextNum;
            
            if(currNum.length() > largestNum.length()) {
                largestNum = currNum;
            }
            else if(currNum.length() == largestNum.length()) {
                if(currNum.compareTo(largestNum) > 0) {
                    largestNum = currNum;
                }
            }
        }
        
        return memo[target] = largestNum;
    }
}