class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }
        
        int longestSequence = 0;
        
        for(int num: nums) {
            if(set.contains(num-1)) {
                continue;
            }
            int sequence = 1;
            int i = num + 1;
            while(set.contains(i)) {
                sequence++;
                i++;
            }
            longestSequence = Math.max(longestSequence, sequence);
        }
        
        return longestSequence;
    }
}