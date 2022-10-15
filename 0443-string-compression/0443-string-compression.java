class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }
        
        
        int modifiedIndex = 1;
        int n = chars.length;
        
        int sameCharCount = 1;
        
        char prevChar = chars[0];
        for(int i = 1; i<n; i++) {
            // If the current char and previous char are the same,
            // increment the count
            if(chars[i] == prevChar) {
                sameCharCount++;
            }
            // If they are different then add the count > 1 to the modifiedIndex, increment it
            // add 
            else {
                if(sameCharCount > 1) {
                    modifiedIndex = addCharCount(chars, sameCharCount, modifiedIndex);  
                }
                sameCharCount = 1;
                prevChar = chars[i];
                chars[modifiedIndex++] = chars[i];
            }
        }
        
        // System.out.println(modifiedIndex + " " + sameCharCount);
        if(sameCharCount > 1) {
            modifiedIndex = addCharCount(chars, sameCharCount, modifiedIndex);
        }
        return modifiedIndex;
    }
    
    private int addCharCount(char[] chars, int count, int index) {
        int numDigits = getNumDigits(count);
        int startIndex = index+numDigits-1; 
        while(count != 0) {
            int digit = count % 10;
            chars[startIndex] = (char)(digit+'0');
            index++;
            count /= 10;
            startIndex--;
        }
        
        return index;
    }
    
    private int getNumDigits(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num/=10;
        }
        
        return count;
    }
}