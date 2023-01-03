class UnionFind {
    int[] parent, rank;
    int n;
    
    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    int find(int u) {
        if(parent[u] == u) return u;
        
        return parent[u] = find(parent[u]);
    }
    
    void union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        
        if(parU == parV) {
            return;
        }
        
        if(rank[parU] >= rank[parV]) {
            parent[parV] = parU;
            if(rank[parU] == rank[parV]) {
                rank[parU]++;
            }
        }
        else {
            parent[parU] = parV;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        Map<String, Integer> emailToNode = new HashMap();
        
        for(int i = 0; i<n; i++) {
            int k = accounts.get(i).size();
            for(int j = 1; j<k; j++) {
                String email = accounts.get(i).get(j);
                
                if(!emailToNode.containsKey(email)) {
                    emailToNode.put(email, i);
                }
                else {
                    uf.union(i, emailToNode.get(email));
                }
            }
        }
        
        Map<Integer, List<String>> nodeToEmails = new HashMap();
        
        for(Map.Entry<String, Integer> map: emailToNode.entrySet()) {
            int node = map.getValue();
            String email = map.getKey();
            
            int parEmail = uf.find(node);
            
            if(!nodeToEmails.containsKey(parEmail)) {
                nodeToEmails.put(parEmail, new ArrayList());
            }
            
            nodeToEmails.get(parEmail).add(email);
        }
                
        List<List<String>> answer = new ArrayList();
        
        for(int node: nodeToEmails.keySet()) {
            List<String> emails = nodeToEmails.get(node);
            Collections.sort(emails);
            
            emails.add(0, accounts.get(node).get(0));
            answer.add(emails);
        }
        
        
        
        return answer;
    }
}

/*
Input: accounts = [
["John","johnsmith@mail.com","john_newyork@mail.com"],
["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]
]


two account same person -- if same email
"john" -- [johnsmith@mail.com, john_newyork@mail.com, john00@mail.com]
"john" -- [johnnybravo@mail.com]
"mary" -- [mary@mail.com]

[
["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"]
["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]
]

"Gabe" -- ["Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"]
"Kevin" -- 
*/