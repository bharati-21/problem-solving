class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        
        int[] cap = new int[n];
        
        for(int i = 0; i<n; i++) {
            cap[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(cap);
        
        int fullBags = 0;
        
        for(int i = 0; i<n; i++) {
            int currCap = cap[i];
            if(currCap == 0) {
                fullBags++;
                continue;
            }
            
            if(currCap <= additionalRocks) {
                additionalRocks -= currCap;
                fullBags++;
            }
            else {
                break;
            }
        }
        
        return fullBags;
    }
}

/*

- Try to fill the bags that are close to capacity as soon as possible

[2,3,4,5]
[1,2,4,4]
[1,1,0,1] cap-rocks

[0,1,1,1] add = 2
i = 0
cap[i] == 0 
    - fullBags++
i = 1
cap[i] == 1
    - fill = |1-2| = 1
    - cap[i]-=1 == 0
    - fullBags++
i = 2
cap[i] == 1
    - fill = |1-1| = 


[10,2,2]
[2,2,0] cap-rocks
[8,0,2]

[0,2,8] add = 100

[7,4,10,1]
[5,1,8,0]
[2,3,2,1]
additional = 3
[1,2,2,3]
[0,1,2,3]

[0,0,2,3]

additional = 11
[2,3,2,1]


[7,4,10,5]
[1,2,5,2]
[6,2,5,3]
[2,3,5,6]

*/