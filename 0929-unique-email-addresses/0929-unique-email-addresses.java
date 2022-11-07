class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        
        for(String email: emails) {
            StringBuilder sb = new StringBuilder("");
            int atIndex = email.indexOf('@');
            for(int i = 0; i<atIndex; i++) {
                char ch = email.charAt(i);
                if(ch == '.') {
                    continue;
                }
                else if(ch == '+') break;
                sb.append(ch);
            }
            
            sb.append(email.substring(atIndex));
            set.add(sb.toString());
        }
        
        return set.size();
    }
}