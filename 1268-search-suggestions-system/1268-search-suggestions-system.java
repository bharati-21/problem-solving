class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> output = new ArrayList();
        int n = searchWord.length();
        
        for(int i = 0; i<n; i++) {
            output.add(i, new ArrayList());
        }
        
        // O(n*m*n)
        StringBuilder search = new StringBuilder();
        for(int i = 0; i<n; i++) {
            search.append(searchWord.charAt(i));
            
            // O(m)
            Set<String> set = new TreeSet<>();
            
            // O(m)
            for(String product: products) {
                if(product.length() < search.length()) {
                    continue;
                }
                StringBuilder sub = new StringBuilder();
                
                // In the worst case this will run O(n) times
                for(int j = 0; j<=i; j++) {
                    sub.append(product.charAt(j));
                }
            
                // O(n)
                if(sub.toString().equals(search.toString())) {
                    set.add(product);
                }
            }
            
            for(String s: set) {
                output.get(i).add(s);
                if(output.get(i).size() == 3) {
                    break;
                }
            }
        }
        
        return output;
    }
}