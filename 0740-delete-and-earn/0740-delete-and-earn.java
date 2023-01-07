class Solution {
    private Map<Integer, Integer> map;
    private int[] cache;
    public int deleteAndEarn(int[] nums) {
        map = new HashMap();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int[] nonDupNums = new int[map.size()];
        int index = 0;
        for(int key: map.keySet()) {
            nonDupNums[index++] = key;
        }
        cache = new int[map.size()];
        Arrays.fill(cache, -1);
        Arrays.sort(nonDupNums);
        return deleteAndEarnHelper(nonDupNums, 0);
    }
    
    // cache[i] represents the max you get from [i..n] if you
    // delete or don't delete this number
    private int deleteAndEarnHelper(int[] nums, int index) {
        int n = nums.length;
        if(index >= n) return 0;
        
        if(cache[index] != -1) return cache[index];
        
        int num = nums[index];
        // If I choose to delete this number
        int nextIndex = index+1;
        if(index+1 < n) {
            if(nums[index+1] == num+1) {
                nextIndex = index+2;
            }
        }
        int delCurrent = num * map.get(num) + deleteAndEarnHelper(nums, nextIndex);
        
        // If I choose to not delete this index
        int keepCurrent = deleteAndEarnHelper(nums, index+1);
        
        return cache[index] = Math.max(delCurrent, keepCurrent);
    }
}

/*
3 -- delete 3
4 and 2

[2,2,3,3,3,4]
points = 2
[2,4]
points = 4
delete 4 = 8

delete 3*3 = 9
delete 2 and 4 consecutively

[2,3,4,5]



*/