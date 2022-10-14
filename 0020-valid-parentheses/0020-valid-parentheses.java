class Solution {
	public boolean isValid(String s) {
		if(s == null || s.length() == 0) {
			return true;
        }
        int n = s.length();
        Stack<Character> openParentheses = new Stack();
        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            if(isOpenParentheses(ch)) {
                openParentheses.push(ch);
            }
            else {
                if(openParentheses.isEmpty()) {
                    return false;
                }
                char top = openParentheses.pop();
                if(!isMatchingParentheses(ch, top)) {
                    return false;
                }
            } 
        }
        return openParentheses.isEmpty();
    }

    private boolean isOpenParentheses(char ch) {
        return (ch == '[' || ch == '{' || ch == '(');
    }

    private boolean isMatchingParentheses(char close, char open) {
        return (close == ')' && open == '(') 
        || (close == ']' && open == '[') 
        || (close == '}' && open == '{');
    }
}
