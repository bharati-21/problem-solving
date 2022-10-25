class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 == null || word1.length == 0 || word2 == null || word2.length == 0) {
            return false;
        }
        
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        for(String word: word1) {
            s1.append(word);
        }
        
        for(String word: word2) {
            s2.append(word);
        }
        
        return areEqual(s1, s2);
    }
    
    private boolean areEqual(StringBuilder s1, StringBuilder s2) {
        if(s1.length() != s2.length()) return false;
        
        int n = s1.length();
        
        for(int i = 0; i<n; i++) {
            char chOne = s1.charAt(i), chTwo = s2.charAt(i);
            if(chOne != chTwo) return false;
        }
        
        return true;
    }
}
