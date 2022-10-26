class Solution {
    public boolean isPerfectSquare(int num) {
        
        int start = 1, end = num;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int sq = num/mid;
            int remainder = num % mid;
            if(sq == mid && remainder == 0) {
                return true;
            }
            
            if(sq > mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return false;
    }
}

/*
16 -> 8 -> 4 -> 2 -> 1
*/