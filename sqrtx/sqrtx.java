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

/*

x = 8
start = 0, end = 4
mid = 2
- 2*2 < 8 => T
start = 1, end = 4
mid = 2
- 2

return 2

x = 15
start = 0, end = 7
mid = 3
3*3 < 15 => T
start = 4, end = 7
mid = 5
5*5 < 15 => F
start = 4, end = 4
mid = 4
4*4 < 15 => F
start = 4, end = 3

return 3

x = 8
start = 0, end = 4
mid = 2
2*2 < 8 
*/