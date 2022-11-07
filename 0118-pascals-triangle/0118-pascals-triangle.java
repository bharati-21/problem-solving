class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        
        triangle.add(new ArrayList());
        triangle.get(0).add(1);
        
        for(int row = 1; row < numRows; row++) {
            List<Integer> l = new ArrayList();
            for(int col = 0; col<=row; col++) {
                List<Integer> prev = triangle.get(row-1);
                
                int first = (col < 1) ? 0 : prev.get(col-1);
                int second = (col == row) ? 0 : prev.get(col);
                
                int sum = first + second;
                l.add(sum);
            }
            
            triangle.add(row, l);
        }
        
        return triangle;
    }
}