class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        
        int res = 10;
        int availableDigits = 9;
        int combinations = 9;
        
        while(n > 1) {
            combinations *= availableDigits;
            res += combinations;
            availableDigits--;
            n--;
        }
        
        return res;
    }
}

/*
n = 1
1 + 9

n = 2
1 + 9 + (9 * 9)

n = 3
1 + 9 + (9 * 9) + 9 * 9 * 8

n = 4
9 * 9 * 8 * 7

n = 5
9 * 9 * 8 * 7 * 6
*/