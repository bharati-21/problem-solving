class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = sum(gas);
        int totalCost = sum(cost);
        
        if(totalCost > totalGas) {
            return -1;
        }
        
        int station = 0;
        int tank = 0;
        for(int i = 0; i<gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                station = i+1;
            }
        }
        
        return station;
    }
    
    
    private int sum(int[] nums) {
        int total = 0;
        for(int num: nums) total += num;
        
        return total;
    }
}

/*
1-3 = -2
2-4 = -2
3-5 = -2
4-1 = 3
5-2 = 3


-2+-2+-2
*/