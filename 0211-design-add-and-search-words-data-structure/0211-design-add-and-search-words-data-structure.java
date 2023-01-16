class WordDictionary {
    Node root;
    
    class Node {
        Node[] children;
        boolean isEnd;
        
        Node() {
            isEnd = false;
            children = new Node[26];
        }
    }
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        
        for(char ch: word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        return searchHelper(word, curr, 0);
    }
    
    private boolean searchHelper(String word, Node curr, int index) {
        if(index == word.length()) {
           return curr.isEnd;
        }
              
        char ch = word.charAt(index);
        if(ch == '.') {
            for(int i = 0; i<curr.children.length; i++) {
                if(curr.children[i] == null) continue;
                // match the ith character with the char at index i
                boolean found = searchHelper(word, curr.children[i], index+1);
                if(found) return true;
            }
            
            return false;
        }
        
        if(curr.children[ch - 'a'] == null) return false;
        return searchHelper(word, curr.children[ch-'a'], index+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */