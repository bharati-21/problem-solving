class Solution {
    public String intToRoman(int num) {
        if(num == 0) {
            return "0";
        }
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        String s = "";
        
        int[] places = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        
        for(int place: places) {
            int digit = num / place;
            if(digit != 0) {
                s+= getRomanSymbol(digit, map.get(place));
            }
            
            num = num % place;
        }
        
        return s;
    }
    
    private String getRomanSymbol(int n, String symbol) {
        StringBuilder sb = new StringBuilder("");
        while(n-- > 0) {
            sb.append(symbol);
        }
        
        return sb.toString();
    }
}

/*
1000 + 900 + 90 + 4
MCMXCIV



50 + 8
LVIII
3999
3000 + 900 + 90 + 9
2456
2000 + 400 + 50 + 6


2465/1000 => 2
MM
465/100 => 4

2745 = 2000 + 200 + 40 + 
MMDCCXL

*/