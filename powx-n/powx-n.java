class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        return myPowHelper(x, n, 1);
    }
    
    private double myPowHelper(double x, int n, double pow) {
        if(n == 0) {
            return pow;
        }
        
        if(n % 2 != 0) {
            pow*=x;
        }
        
        return myPowHelper(x * x, n / 2, pow);
    }
}

/*
n = 10
myPow(10) => x * 
myPow(5) => return x*x*x*x
myPow(2) => return x*
myPow(1) => return 1 * x
myPow(0) => 1
*/