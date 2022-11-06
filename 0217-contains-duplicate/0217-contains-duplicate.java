class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        Set<Integer> set = new HashSet();
        
        for(int num: nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Brute Force: run 2 loops check for every i if there exists elements in the array at [i+1,n]
Sorting: check for adjacent elements if they are equal
O(n): Use a set, if while trying to add an element it results in false, return true
*/