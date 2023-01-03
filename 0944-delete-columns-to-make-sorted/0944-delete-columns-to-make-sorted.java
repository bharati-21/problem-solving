class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length(); 
        
        int delCount = 0;
        
        for(int col = 0; col < m; col++) {
            for(int row = 0; row < n-1; row++) {
                String curr = strs[row];
                String next = strs[row+1];
                
                if(curr.charAt(col) > next.charAt(col)) {
                    delCount++;
                    break;
                }
            }
        }
        
        return delCount;
    }
}

/*
c b a
d a f
g h i

i = 0, j = 0 => 'c' compare 'c' and 'd'
i = 1, j = 1 => 'b'
*/