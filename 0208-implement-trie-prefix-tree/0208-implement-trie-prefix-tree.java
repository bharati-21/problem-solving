class Trie {
    TrieNode root;
    
    class TrieNode {
        char ch;
        Map<Character, TrieNode> children;
        boolean isWord;
        TrieNode(char ch) {
            this.ch = ch;
            children = new HashMap();
            isWord = false;
        }
    }
    
    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        int n = word.length();
        
        TrieNode current = root;
        for(int i = 0; i<n; i++) {
            char ch = word.charAt(i);
            
            if(!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode(ch));
            }
            
            current = current.children.get(ch);
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode current = root;
        
        for(int i = 0; i<n; i++) {
            char ch = word.charAt(i);
            
            if(!current.children.containsKey(ch)) {
                return false;
            }
            
            current = current.children.get(ch);
        }
        
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode current = root;
        
        for(int i = 0; i<n; i++) {
            char ch = prefix.charAt(i);
            
            if(!current.children.containsKey(ch)) {
                return false;
            }
            
            current = current.children.get(ch);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */