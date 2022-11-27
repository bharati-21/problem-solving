class Solution {
    private int mod = (int) 1e9 + 7;
    public int maximumProduct(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int num: nums) {
            minHeap.add(num);
        }
        
        while(count < k) {
            int smallest = minHeap.poll();
            minHeap.add(smallest+1);
            count++;
        }
        
        long product = 1;
        while(!minHeap.isEmpty()) {
            product = product * minHeap.poll();
            product %= mod;
        }
        
        return (int) product;
    }
}

/*
Observations:
- Any number can be incremented by 1
- The total number of increments can be at max k
- The same number can be incremented k times

[0,4]
- increment index 0 => 1,4 => k = 4
    - increment index 0 => 2,4 => k = 3
        - increment index 0 => 3,4 => k = 2
            - increment index 0 => 4,4 => k = 1
                - increment index 0 => 5,4 => k = 0
                - increment index 1 => 4,5 => k = 0
            - increment index 1 => 3,5 => k = 1
                - increment index 0 => 4,5 => k = 0
                - increment index 1 => 3,6 => k = 0
        - increment index 1 => 2,5 => k = 2
            - increment index 0 => 3,5 => k = 1
                - increment index 0 => 4,5 => k = 0
                - increment index 1 => 3,6 => k = 0
            - increment index 1 => 2,6 => k = 1
                - increment index 0 => 3,6 => k = 0
                - increment index 1 => 2,7 => k = 0
    - increment index 1 => 1,5 => k = 3
        - increment index 0 => 2,5 => k = 2
            - increment index 0 => 3,5 => k = 1
                - increment index 0 => 4,5 => k =1
                - increment index 1 => 3,6 => k = 0
            - increment index 1 => 2,6 => k = 1
                - increment index 0 => 3,6 => k = 0
                - increment index 1 => 2,7 => k = 0
        - increment index 1 => 1,6 => k = 2
            - increment index 0 => 2,6 => k = 1
            - increment index 1 => 1,7 => k = 1
- increment index 1 => 0,5 => k = 4
    - increment index 0 => 1,5 => k = 3
    - increment index 1 => 0,6 => k = 2

dp[i][k]
*/

/*
If I can increment only once:
    - Then incremnt the smallest number
*/