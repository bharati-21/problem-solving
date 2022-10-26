class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int k = removable.length;
        int start = 0, end = k-1;
        
        int maxRemovals = 0;
        while(start <= end) {
            int mid = (start + end)/2;
            // try removing [0,mid] characters
            Set<Integer> set = new HashSet();
            
            for(int i = 0; i<=mid; i++) {
                int remove = removable[i];
                set.add(remove);
            }
            
            if(isSubsequence(s, p, set)) {
                maxRemovals = Math.max(maxRemovals, mid+1);
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        
        return maxRemovals;
    }
    
    private boolean isSubsequence(String s, String p, Set<Integer> set) {
        int i = 0, j = 0;
        int n = s.length(), m = p.length();
        
        while(i < n && j < m) {
            char sh = s.charAt(i);
            char ph = p.charAt(j);
            if(set.contains(i) || sh != ph) {
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        
        return j == m;
    }
}