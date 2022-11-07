class Solution {
    public int maximum69Number (int num) {
        int k = 0;
        
        int n = num;
        k = -1;
        int currentDigit = 0;
        while(n > 0) {
            int dig = n % 10;
            
            if(dig == 6) {
                k = currentDigit;
            }
            
            currentDigit++;
            n /= 10;
        }
        
        if(k == -1) return num;
        
        return num + 3 * (int)(Math.pow(10, k));
    }
}
