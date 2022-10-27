class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode() {
            children = new HashMap();
            isEnd = false;
        }
    }
    
    public void insert(String word) {
        int len = word.length();
        TrieNode curr = root;
        
        for(int i = 0; i<len; i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        int len = word.length();
        
        for(char ch: word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        
        if(!curr.isEnd) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int len = prefix.length();
        
        for(char ch: prefix.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
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