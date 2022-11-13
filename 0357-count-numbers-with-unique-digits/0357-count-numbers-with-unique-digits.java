class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        
        int res = 10;
        /*
        n = 3
            _ _ _
        */
        
        while(n > 1) {
            int digits = n-1;
            int digitsAvailable = 9;
            int combinations = 9;
            
            while(digits > 0) {
                combinations *= digitsAvailable;
                digitsAvailable--;
                digits--;
            }
            
            res += combinations;
            n--;
        }
        
        return res;
    }
}

/*
*/