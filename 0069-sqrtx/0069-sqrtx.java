class Solution {
    public int mySqrt(int x) {
        long start = 0, end = x;
        
        while(start <= end) {
            long mid = start + (end - start)/2;
            long square = mid * mid;
            
            if(square > x) {
                end = mid-1;
            }
            else if(square < x) {
                start = mid + 1;
            }
            else {
                return (int) mid;
            }
        }
        
        return (int) end;
    }
}