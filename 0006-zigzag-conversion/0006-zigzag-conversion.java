class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        List<StringBuilder> rows = new ArrayList();
        int n = s.length();
        
        for(int i = 0; i < Math.min(n, numRows); i++) {
            rows.add(new StringBuilder());
        }
        
        int row = 0;
        boolean isDown = true;
        
        for(char c: s.toCharArray()) {
            rows.get(row).append(c);
            if(row == 0 && !isDown) {
                isDown = true;
            }
            else if(row == numRows-1 && isDown) {
                isDown = false;
            }
            
            row += (isDown ? 1 : -1);
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(StringBuilder rowS: rows) {
            ans.append(rowS);
        }
        
        return ans.toString();
    }
}

/*
P     I     N
A   L S   I G
Y A   H R
P     I
*/
