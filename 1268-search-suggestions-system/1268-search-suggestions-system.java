class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> output = new ArrayList();
        int n = searchWord.length();
        
        for(int i = 0; i<n; i++) {
            output.add(i, new ArrayList());
        }
        
        for(int i = 0; i<n; i++) {
            String search = searchWord.substring(0, i+1);
            
            Set<String> set = new TreeSet<>();
            for(String product: products) {
                if(product.length() < search.length()) {
                    continue;
                }
                String sub = product.substring(0, i+1);
                if(search.equals(sub)) {
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