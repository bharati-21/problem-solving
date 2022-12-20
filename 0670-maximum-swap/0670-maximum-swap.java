class Solution {
    public int maximumSwap(int num) {
        // swap the first number with the maximum number
        // if the first number is already the max number, then try swa
        
        int n = getNumberOfDigits(num);
        int[] digits = new int[n];
        
        int i = n-1;
        while(num > 0) {
            digits[i--] = num % 10;
            num /= 10;
        }
        
        i = 0;

        while(i < n) {
            int digit = digits[i];
            int max = digits[i];
            int index = i;
            
            for(int j = i+1; j < n; j++) {
                if(digits[j] != digit && digits[j] >= max) {
                    max = digits[j];
                    index = j;
                }
            }
            
            if(index != i) {
                digits[index] = digit;
                digits[i] = max;
                break;
            }
            i++;
        }
                
        int swappedNum = 0;
        i = 0;
        while(i < n) {
            swappedNum = (swappedNum*10) + digits[i];
            i++;
        }
        
        return swappedNum;
    }
    
    private int getNumberOfDigits(int num) {
        int count = 0;
        while(num > 0) {
            num/=10;
            count++;
        }
        
        return count;
    }
}