class Solution {
    List<List<String>> palindromes;
    public List<List<String>> partition(String s) {
        palindromes = new ArrayList();
        
        partitionHelper(s, 0, new ArrayList<String>());
        
        return palindromes;
    }
    
    private void partitionHelper(String s, int index, List<String> list) {
        if(index >= s.length()) {
            palindromes.add(new ArrayList(list));
        }
        
        for(int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i+1);
            if(checkPalindrome(substr)) {
                list.add(substr);
                partitionHelper(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean checkPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;
        
        while(i < j) {
            if(chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
}