class Solution {
    Set<String> set;
    List<String> ans;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet();
        ans = new ArrayList();
        
        for(String word: words) {
            set.add(word);
        }
        
        for(String word: words) {
            boolean hasConcat = checkConcatenation(word);
            if(hasConcat) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    private boolean checkConcatenation(String word) {
        for(int i = 0; i<word.length(); i++) {
            String prefix = word.substring(0,i);
            String suffix = word.substring(i);
            
            if(set.contains(prefix)) {
                if(set.contains(suffix)) {
                    return true;
                }
                if(checkConcatenation(suffix)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}