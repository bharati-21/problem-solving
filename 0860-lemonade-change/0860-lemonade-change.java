class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills == null || bills.length == 0) {
            return false;
        }
        
        int five = 0, ten = 0;
        
        for(int bill: bills) {
            if(bill == 5) {
                five++;
            }
            else if(bill == 10) {
                if(five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else {
                if(five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if(five >= 3) {
                    five-=3;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}


/*
1. cL = 0, num = 5, cR = 5-5 => 0
cR > cL => F
cL += 5-0 => 5
2. cL = 5, num = 5, cR = 5-5 => 0
cR > cL => F
cl += 5-0 => 5
3. cL = 10, num = 10, cR = 10-5 => 5
cR > cL (5 > 10) => F
cL += (10-5) 
*/
