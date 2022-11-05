class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    TrieNode() {
        children = new HashMap();
        this.isEnd = isEnd;
    }
    
    public void addWord(String word) {
        TrieNode curr = this;
        for(int i = 0; i<word.length(); i++) {
            char ch = word.charAt(i);
            
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            
            curr = curr.children.get(ch);
        }
        
        curr.isEnd = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        
        TrieNode root = new TrieNode();
        for(String word: words) {
            root.addWord(word);
        }
        
        List<String> output = new ArrayList();
         
        Set<String> visitedWord = new HashSet();
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                searchBoard(board, i, j, root, "", visited, visitedWord);
            }
        }
        
        for(String word: visitedWord) {
            output.add(word);
        }
        return output;
    }
    
    // 
    private void searchBoard(char[][] board, int row, int col, TrieNode root, String word, boolean[][] visited, Set<String> visitedWord) {
        int m = board.length, n = board[0].length;
        int wordLen = word.length();
        
        if(row >= m || row < 0 || col >= n || col < 0 || visited[row][col]) {
            return;
        }
        
        char currChar = board[row][col];
        if(!root.children.containsKey(currChar)) {
            return;
        }
        
        visited[row][col] = true;
        
        int[][] directions = new int[][] {
            {-1, 0}, {1,0}, {0,-1}, {0,1}
        };
        
        root = root.children.get(currChar);
        word += currChar;
        
        
        if(root.isEnd) {
            
            visitedWord.add(word);
        }
        
        for(int[] dir: directions) {
            int nRow = dir[0] + row;
            int nCol = dir[1] + col;
            searchBoard(board, nRow, nCol, root, word, visited, visitedWord);
        }
        
        visited[row][col] = false;
    }
}