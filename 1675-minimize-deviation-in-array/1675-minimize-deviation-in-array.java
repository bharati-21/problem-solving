class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        
        for(int i = 0; i<nums.length; i++) {
            int num = nums[i];
            
            if(num % 2 != 0) {
                set.add(num * 2);
            }
            else {
                set.add(num);
            }
        }
        
        int maxDiff = Integer.MAX_VALUE;
        
        while(true) {
            int max = set.last();
            int min = set.first();
            
            maxDiff = Math.min(maxDiff, (max-min));
            
            if(max % 2 == 0) {
                set.remove(max);
                set.add(max/2);
            }
            else {
                break;
            }
        }
        
        return maxDiff;
    }
}