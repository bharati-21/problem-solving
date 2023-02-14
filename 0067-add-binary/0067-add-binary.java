class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length() - 1;
        
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        
        while(i >= 0 || j >= 0) {
            int s = carry;
            if(i >= 0) {
                s += a.charAt(i) - '0'; 
                i--;
            }
            if(j >= 0) {
                s += b.charAt(j) - '0';
                j--;
            }
            
            sum.append(s % 2);
            carry = s / 2;
        }
        
        if(carry != 0) {
            sum.append(carry);
        }
        
        return sum.reverse().toString();
    }
}