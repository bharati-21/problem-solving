class Solution {
    int len = (int) 1e4;
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        // Reason being we only have numbers from -10,000 to +10,000
        // And the total length of the array is 10,000 at max
        // Hence out array size will be 2 * 10,000 + 1 (0 as wekk)
        // And since an element's indices will be based on the element value,
        // we will have to add 10,000 to accomodate -ve nums too.
        int[] frequency = new int[2 * len + 1];
        // O(N)
        for(int num: nums) {
            // -10,000 -> 0
            // 0 -> 10,000
            // 1 -> 10,001
            // -1 -> 9,999
            frequency[num + len]++;
        }
        // Why the below solution works?
        // We save the frequency of every number
        // Let's say the array was like this: 6 5 2 1 3 1 4 5
        // Then after counting freq, it would be:
        // 10,001: 2
        // 10,002: 1
        // 10,003: 1
        // 10,004: 1
        // 10,005: 2
        // 10,006: `
        // Basically: 1 1 2 3 4 5 5 6 
        // So the sum of min element from every pair will be:
            // 1 + 2 + 4 + 5 => 12
        // We use a boolean flag to switch between alternative elements
        
        // O(K)
        int pairSum = 0;
        boolean isEvenIndex = true;
        for(int num = 0; num <= 2*len; num++) {
            int freq = frequency[num];
            while(freq > 0) {
                pairSum += (isEvenIndex) ? num-len : 0;
                isEvenIndex = !isEvenIndex;
                freq--;
            }
        }
        
        return pairSum;
    }
}