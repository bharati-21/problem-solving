class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = 0;
        Map<Integer, Integer> count = new HashMap();
        for(int num: nums) {
            if(!count.containsKey(num)) {
                count.put(num, 1);
                if(1 > n/2) majority = num;
            }
            else {
                int c = count.get(num) + 1;
                if(c > n/2) {
                    majority = num;
                    break;
                }
                count.put(num, c);
            }
        }
        
        return majority;
    }
}
