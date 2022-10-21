class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            if(map.containsKey(num) && map.get(num) != i) {
                int j = map.get(num);
                int diff = Math.abs(i - j);
                if(diff <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        
        return false;
    }
}

/*
1 -> 0
0 > 1
*/