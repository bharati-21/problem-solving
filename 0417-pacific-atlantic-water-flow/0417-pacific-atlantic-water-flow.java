class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rainFlow = new ArrayList();
        
        if(heights == null || heights.length == 0) {
            return rainFlow;
        }
        
        int m = heights.length, n = heights[0].length;
        Queue<int[]> pacQueue = new LinkedList(), atlQueue = new LinkedList();
        Set<List<Integer>> seenPac = new HashSet(), seenAtl = new HashSet();
        
        for(int i = 0; i<n; i++) {
            pacQueue.add(new int[] { 0, i });
            atlQueue.add(new int[] { m-1, i });
            
            List<Integer> listPac = new ArrayList();
            listPac.add(0); 
            listPac.add(i);
            seenPac.add(listPac);
            
            List<Integer> listAtl = new ArrayList();
            listAtl.add(m-1);
            listAtl.add(i);
            seenAtl.add(listAtl);
        }
        
        for(int i = 0; i<m; i++) {
            pacQueue.add(new int[] { i, 0 });
            atlQueue.add(new int[] { i, n-1 });
            
            List<Integer> listPac = new ArrayList();
            listPac.add(i); 
            listPac.add(0);
            seenPac.add(listPac);
            
            List<Integer> listAtl = new ArrayList();
            listAtl.add(i);
            listAtl.add(n-1);
            seenAtl.add(listAtl);
        }
        
        bfs(pacQueue, m, n, heights, seenPac);
        bfs(atlQueue, m, n, heights, seenAtl);
        
        for(List<Integer> cellAtl: seenAtl) {
            for(List<Integer> cellPac: seenPac) {
                if(cellPac.equals(cellAtl)) {
                    rainFlow.add(cellPac);
                }
            }
        }
        
        return rainFlow;
    }
    
    private void bfs(Queue<int[]> queue, int m, int n, int[][] heights, Set<List<Integer>> seen) {
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int height = heights[row][col];
            
            for(int[] dir: directions) {
                int nRow = dir[0] + row;
                int nCol = dir[1] + col;
                
                List<Integer> newCell = new ArrayList();
                newCell.add(nRow);
                newCell.add(nCol);
                
                if(!isValid(nRow, nCol, m, n, heights, height, seen, newCell)) {
                    continue;
                }
                
                queue.add(new int[] { nRow, nCol });
                seen.add(newCell);
            }
            
        }
    }
    
    
    private boolean isValid(int row, int col, int m, int n, int[][] heights, int prevHeight, Set<List<Integer>> seen,  List<Integer> cell) {
        if(row < 0 || row >= m || col < 0 || col >= n || heights[row][col] < prevHeight || seen.contains(cell)) {
            return false;
        }        
        
        return true;
    }
}