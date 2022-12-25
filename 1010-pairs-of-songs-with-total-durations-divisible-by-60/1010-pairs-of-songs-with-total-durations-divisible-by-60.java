class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainderCount = new HashMap();
        
        int pairs = 0;
        
        for(int t: time) {
            int remainder = t % 60;
            int complementRemainder = (60 - remainder);
            if(remainder == 0) {
                complementRemainder = 0;
            }
            if(remainderCount.containsKey(complementRemainder)) {
                pairs += remainderCount.get(complementRemainder);
            }
            
            if(remainderCount.containsKey(remainder)) {
                remainderCount.put(remainder, remainderCount.get(remainder)+1);
            }
            else {
                remainderCount.put(remainder, 1);
            }
        }
        
        return pairs;
    }
}

// total pairs n^2

// [20, 30, 40, 100, 150]
// total = 340
// Add these numbers to a map
// then find 

// [20%60, 30%60, 40%60, 100%60, 150%60]
// [20,30,40,1,]