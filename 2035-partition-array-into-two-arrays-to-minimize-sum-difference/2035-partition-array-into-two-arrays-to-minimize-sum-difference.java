class Solution {
    public int minimumDifference(int[] nums) {
        Map<Integer, List<Integer>> sumSetOne = new HashMap(), sumSetTwo = new HashMap();
        
        int n = nums.length; // 3
        int half = n/2; // 1
        // [0]
        // [1,2]
        // [0,1]
        // [2,3]
        
        // [0,1]
        // [2,3,4]
        
		//storing all possible sum in left and right part
        for(int mask = 0; mask<(1<<half); ++mask){
            int sz = 0, l = 0, r = 0;
            for(int i=0; i<half; ++i){
                if((mask & (1<<i)) != 0){
                    sz++;
                    l += nums[i];
                    r += nums[i+half];
                }
            }
            if(!sumSetTwo.containsKey(sz)) sumSetTwo.put(sz, new ArrayList());
            if(!sumSetOne.containsKey(sz)) sumSetOne.put(sz, new ArrayList());
            sumSetOne.get(sz).add(l);
            sumSetTwo.get(sz).add(r);
        }
        
        for(int i = 0; i<half; i++) {
            Collections.sort(sumSetTwo.get(i));
        }
        
        int sum = getSum(nums, 0, n);
        int leftSum = getSum(nums, 0, half);
        int rightSum = getSum(nums, half, n);
        
        int leftSumDiff = Math.abs(sum - 2*leftSum);
        int rightSumDiff = Math.abs(sum - 2*rightSum);
        
        int minDiff = Math.min(leftSumDiff, rightSumDiff);
        
        /*
            sum - ((2 * sumOne) + (2 * sumTwo)) >= 0
            sum - (2 * (sumOne + sumTwo)) >= 0
            sum = 2 * (sumOne + sumTwo)
            sum/2 = (sumOne + sumTwo)
            sum/2 - sumOne = sumTwo
            (sum - 2*sumOne)/2 = sumTwo
        */
        
        for(int k: sumSetOne.keySet()) {
            int j = half - k;
            List<Integer> l1 = sumSetOne.get(k);
            
            for(int subsetSum: l1) {
                int goal = (sum - (2 * subsetSum)) / 2;
                List<Integer> l2 = sumSetTwo.get(j);
                int m = l2.size();
                
                int position = Collections.binarySearch(l2, goal);
                if(position >= 0) {
                    int diff = Math.abs(sum - 2 * (subsetSum + goal));
                    return diff;
                };
                
                position = -1 * (position + 1);
                int low = position-1;
               
                if(position != m) {
                    int diff = Math.abs(sum - 2 * (subsetSum + l2.get(position)));
                    minDiff = Math.min(minDiff, diff);
                }
                if(low >= 0) {
                    int diff = Math.abs(sum - 2 * (subsetSum + l2.get(low)));
                    minDiff = Math.min(minDiff, diff);
                }
            }
        }
        
        return minDiff;
    }
    
    private int getSum(int[] nums, int start, int end) {
        int sum = 0;
        while(start < end) {
            sum += nums[start++];
        }
        
        return sum;
    }
}