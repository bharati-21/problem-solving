class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        
        int start = 1, end = x;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            int condition = x / mid; // mid =  square * square
            
            if(mid > condition) {
                end = mid-1;
            }
            else if(mid < condition) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        
        return end;
    }
}