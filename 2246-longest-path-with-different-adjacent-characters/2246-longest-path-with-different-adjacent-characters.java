class Solution {
    int lPath = 1;
    Map<Integer, List<Integer>> children;
    
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        children = new HashMap();
        for(int i = 0; i<n; i++) {
            int p = parent[i];
            int c = i;
            if(!children.containsKey(p)) {
                children.put(p, new ArrayList());
            }
            children.get(p).add(c);
        }
        
        traverseRecursively(0, s);
        
        return lPath;
    }
    
    private int traverseRecursively(int curr, String s) {
        if(!children.containsKey(curr)) {
            // A lone node can be it's own path
            return 1;
        }
        
        int longestChain = 0, secondLongestChain = 0;
        for(int child: children.get(curr)) {
            int childLongestChain = traverseRecursively(child, s);
            
            // if the curr node and child node have same char
            if(s.charAt(child) == s.charAt(curr)) {
                continue;
            }
            
            if(childLongestChain > longestChain) {
                secondLongestChain = longestChain;
                longestChain = childLongestChain;
            }
            else if(childLongestChain > secondLongestChain) {
                secondLongestChain = childLongestChain;
            }
            
        }
        int currLPath = 1 + longestChain + secondLongestChain;
        lPath = Math.max(currLPath, lPath);

        return longestChain + 1;
    }
}