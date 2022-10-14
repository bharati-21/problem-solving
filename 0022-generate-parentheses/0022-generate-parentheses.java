class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return new ArrayList();
        }
        
        return generateParenthesesHelper(n, 1, "(", 0);
    }
    
    private List<String> generateParenthesesHelper(int n, int numOpen, String processed, int numMatched) {
        List<String> list = new ArrayList();
        // All the parentheses have been matched
        if(numOpen == n && numMatched == n) {
            list.add(processed);
            return list;
        }
        
        // Now we have 2 options
        // either open a new parentheses or close a previous parentheses
        
        
        // 1. If there are any more open parentheses left
        if(numOpen < n) {
            list.addAll(generateParenthesesHelper(n, numOpen+1, processed + "(", numMatched));
        }
        
        // 2. If there are still any more parentheses left to close
        // 3. If there were any previous open parenthese then only we can close.
        if(numMatched < n && numMatched < numOpen) {
            list.addAll(generateParenthesesHelper(n, numOpen, processed + ")", numMatched+1));
        }
        return list;
    }
}

/*
n = 1 => ()
n = 2 => ()(), (())
n = 3 => ((())), (())(), (()()), ()(()), ()()()
*/