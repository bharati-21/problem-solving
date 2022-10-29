class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        if(plantTime == null || plantTime.length == 0 || growTime == null || growTime.length == 0) {
            return 0;
        }
        
        int n = plantTime.length;
        int[][] plants = new int[n][2];
        
        for(int i = 0; i<n; i++) {
            plants[i] = new int[] {
                plantTime[i], growTime[i]
            };
        }
        
        Arrays.sort(plants, new CustomComparator());
        // for(int[] row: plants) {
        //     System.out.println(Arrays.toString(row));
        // }
        
        int pTime = 0, gTime = 0;
        for(int i = 0; i<n; i++) {
            pTime = pTime + plants[i][0];
            gTime = Math.max(gTime, pTime + plants[i][1]);
        }
        
        return gTime;
    }
}

class CustomComparator implements Comparator<int[]> {
    public int compare(int[] plant1, int[] plant2) {
        return plant2[1] - plant1[1];
    }
}


// You don't have to plan on non-consecutive days
// Plan seeds first that have a longer growth time

// 0 -> 1
// 1 -> 3
// 1 -> 3
// 3 -> 4
// 3 -> 6
// 6 -> 8
// 6 -> 8

// [1,4]
// [2,3]
// 0 -> 0 (plant done)
// 1 -> 3 (blooms)
// 1 -> 4
// 5 -> 8

// 0 -> 3
// 4 -> 7
// 4 -> 4
// 5 -> 7

// [1,3,2,2]
// [2,2,1,1]
// 0 -> 0
// 1 -> 3 (blooms)
// 1 -> 3
// 4 -> 6 (blooms)
// 4 -> 5
// 6 -> 7
// 6 -> 7
// 8 -> 9

// [1,1]
// [1,2]
// 0 -> 0
// 1 -> 2
// 1 -> 1
// 2 -> 4

// 0 -> 0
// 1 -> 3
// 1 -> 1
// 2 -> 3