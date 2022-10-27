class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        if(nums == null || nums.length == 0) {
            return 0;
        }
        for(int num: nums) {
            set.add(num);
        }
        
        int longestStreak = 1;
        for(int num: nums) {
            int currStreak = 1;
            // This is to ensure that you don't calculate the next set of numbers for 
            // all the consecutive numbers and do it for the first one alone
            if(!set.contains(num-1)) {
                while(set.contains(num+1)) {
                    currStreak++;
                    num++;
                }
            }
            
            longestStreak = Math.max(longestStreak, currStreak);
        }
        
        return longestStreak;
    }
}