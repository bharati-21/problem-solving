class Solution {
    Set<String> visited;
    Map<String, List<String>> emailList;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        visited = new HashSet();
        emailList = new HashMap();
        
        for(List<String> emails: accounts) {
            int numEmails = emails.size();
            
            String firstEmail = emails.get(1);
            
            for(int i = 2; i < numEmails; i++) {
                String email = emails.get(i);
                
                if(!emailList.containsKey(firstEmail)) {
                    emailList.put(firstEmail, new ArrayList());
                }
                emailList.get(firstEmail).add(email);
                
                if(!emailList.containsKey(email)) {
                    emailList.put(email, new ArrayList());
                }
                emailList.get(email).add(firstEmail);
            }
        }
        
        
        List<List<String>> finalAccount = new ArrayList();
        for(List<String> emails: accounts) {
            String accountName = emails.get(0);
            String firstEmail = emails.get(1);
            
            if(!visited.contains(firstEmail)) {
                List<String> accountEmails = new ArrayList();

                traverseEmails(accountEmails, firstEmail);
                Collections.sort(accountEmails);
                accountEmails.add(0, accountName);

                finalAccount.add(accountEmails);
            }
        }
        
        
        
        return finalAccount;
    }
    
    private void traverseEmails(List<String> accountEmails, String email) {
        visited.add(email);
        
        accountEmails.add(email);
        
        if(!emailList.containsKey(email)) return;
        
        for(String nextEmail: emailList.get(email)) {
            if(!visited.contains(nextEmail)) {
                traverseEmails(accountEmails, nextEmail);
            }
        }
    }
}