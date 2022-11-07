class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        
        triangle.add(new ArrayList());
        triangle.get(0).add(1);
        
        for(int row = 1; row < numRows; row++) {
            List<Integer> l = new ArrayList();
            l.add(1);
            for(int col = 1; col<row; col++) {
                List<Integer> prev = triangle.get(row-1);
                int sum = prev.get(col-1) + prev.get(col);
                l.add(sum);
            }
            l.add(1);
            
            triangle.add(row, l);
        }
        
        return triangle;
    }
}