class Solution {
    int dummyVal = (int) 1e5;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][];
        for(int i = 0; i<n; i++) {
            memo[i] = new int[triangle.get(i).size()];
            Arrays.fill(memo[i], dummyVal);
        }
        
        return minPathSumHelper(triangle, 0, 0, n, memo);
    }
    
    private int minPathSumHelper(List<List<Integer>> triangle, int i, int j, int n, int[][] memo) {
        if(i == n-1) {
            return triangle.get(i).get(j);
        }
        
        if(memo[i][j] != dummyVal) {
            return memo[i][j];
        }
        
        int curr = triangle.get(i).get(j);
        
        int bottom = minPathSumHelper(triangle, i+1, j, n, memo);
        int diagonal = minPathSumHelper(triangle, i+1, j+1, n, memo);
        return memo[i][j] = curr + Math.min(bottom, diagonal); 
    }
}