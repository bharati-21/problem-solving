class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0) {
            return 0;
        }
        
        if(piles.length > h) {
            return 0;
        }
        
        int max = getMax(piles);
        
        int start = 1, end = max;
        int k = max;
        while(start <= end) {
            int mid = (start + end)/2;
            
            boolean canEatAll = checkCanEatAll(mid, piles, h);
            if(canEatAll) {
                k = Math.min(k, mid);
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        
        return k;
    }
    
    private int getMax(int[] piles) {
        int max = 0;
        
        for(int p: piles) {
            max = Math.max(p, max);
        }
        
        return max;
    }
    
    private boolean checkCanEatAll(int k, int[] piles, int h) {
        double total = 0;
        
        for(int p: piles) {
            total += Math.ceil(p/k);
            if(p % k != 0) {
                total++;
            }
        }
        
        return total <= h;
    }
}

// 16 + 30 = 46/2 = 23

/*
3/4 = 0
6/4 = 1
7/4 = 1
11/4 = 2
*/