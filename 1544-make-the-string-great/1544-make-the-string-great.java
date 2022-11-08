class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        StringBuilder good = new StringBuilder();
        int n = s.length();
        
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty()) {
                char top = stack.peek();
                if(Math.abs(top - ch) == 32) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        
        for(char ch: stack) {
            good.append(ch);
        }
        
        return good.toString();
    }
}