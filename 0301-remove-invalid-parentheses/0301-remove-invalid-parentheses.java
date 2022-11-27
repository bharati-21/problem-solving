class Solution {
    private int minRemoved;
    private Set<String> expressions;
    
    private int n;
    public List<String> removeInvalidParentheses(String s) {
        expressions = new HashSet();
        minRemoved = Integer.MAX_VALUE;
        List<String> answer = new ArrayList();
        n = s.length();
        
        removeInvalidParenthesesHelper(0, 0, 0, 0, new StringBuilder(), s);
        for(String str: expressions) {
            answer.add(str);
        }
        
        return answer;
    }
    
    private void removeInvalidParenthesesHelper(int index, int openCount, int closeCount, int removed, StringBuilder expression, String s) {
        if(index == n) {
            if(openCount == closeCount) {
                if(removed <= minRemoved) {
                    if(removed < minRemoved) {
                        expressions.clear();
                        minRemoved = removed;
                    }
                    expressions.add(expression.toString());
                }
            }
            return;
        }
        
        char curr = s.charAt(index);
        int length = expression.length();
        
        if(curr != ')' && curr != '(') {
            expression.append(curr);
            removeInvalidParenthesesHelper(index + 1, openCount, closeCount, removed, expression, s);
            expression.deleteCharAt(length);
        }
        else {
            // delete current character
            removeInvalidParenthesesHelper(index + 1, openCount, closeCount, removed + 1, expression, s);
            expression.append(curr);
            if(curr == '(') {
                removeInvalidParenthesesHelper(index + 1, openCount + 1, closeCount, removed, expression, s);
            }
            else if(closeCount < openCount) {
                removeInvalidParenthesesHelper(index + 1, openCount, closeCount + 1, removed, expression, s);
                
            }
            expression.deleteCharAt(length);
        }
    }
}

/*

Find the parenthesis that makes the string invalid and remove them all
- At every position, you have two choices:
    - Remove the parenthesis or don't
    - If removed, check if the new one makes a valid string.
        - If yes, add to list
        - If not, then continue
    - If not removed, then check for future ones
    
    ()())()
        )())() => invalid
            )())()
        (())() => valid
    

*/