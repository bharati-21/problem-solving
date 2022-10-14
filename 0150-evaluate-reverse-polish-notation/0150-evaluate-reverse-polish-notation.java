class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Deque<Integer> stack = new ArrayDeque();
        int total = 0;
        for(String token: tokens) {
            if(isNumber(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int first = stack.pop();
            int second = stack.pop();
            int ans = 0;
            switch(token) {
                case "+":
                    ans = (first + second);
                    break;
                case "-":
                    ans = (second - first);
                    break;
                case "*":
                    ans =  (second * first);
                    break;
                case "/":
                    ans = (second / first);
                    break;
            }
            stack.push(ans);
        }
        return stack.pop();
    }
                                                 
    private boolean isNumber(String token) {
        return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}