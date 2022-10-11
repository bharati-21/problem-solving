class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if(n == 0) {
            return true;
        }
        
        int plotLen = flowerbed.length;
        int flowersPlanted = 0;
        for(int plot = 0; plot < plotLen && flowersPlanted < n;) {
            int status = flowerbed[plot];
            // You can't plant next to this, so you move ahead.
            if(status == 1) {
                plot+=2;
            }
            // You have an empty flowerbed
            else {
                // If the next flower pot does not have a plant
                if(plot < plotLen-1) {
                    if(flowerbed[plot+1] != 1) {
                        flowersPlanted++;
                        plot+=2;
                    }
                    // You can't plot here, you can't plot in next as it's already planted
                    // You can't plot in the next to next as well since previous is planted
                    else {
                        plot+=3;
                    }
                }
                // You are at the end of the plot so you can plant here
                else {
                    flowersPlanted++;
                    plot+=2;
                }
            }
        }
        
        return flowersPlanted == n;
    }
}

/*
    Intuition:
    - start from Left to right
    - 2 possibilites at every i:
        - the plot has a plant
            - move i+2 
        - that plot is empty
            - check if the adjacent has a plant
                - Yes, skip this and move i+3
                - No, then plant here and move i+2
*/