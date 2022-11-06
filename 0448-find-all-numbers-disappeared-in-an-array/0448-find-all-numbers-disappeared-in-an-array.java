class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList();
        if(nums == null || nums.length == 0) {
            return missing;
        }
        
        int n = nums.length;
        int i = 0;
    
        while(i < n) {
            int num = nums[i];
            int index = num-1;
            if(nums[index] == num) {
                i++;
                continue;
            }
            int temp = nums[index];
            nums[index] = num;
            nums[i] = temp;
        }
        
        for(i = 0; i<n; i++) {
            if(nums[i] != i+1) {
                missing.add(i+1);
            }
        }
        
        return missing;
    }
}

/*
[4,3,2,7,8,2,3,1]
[1,2,2,3,3,4,7,8]

Naive: Run an outer loop from 1 to n. For any missing number in the array add to list
Sort: Sort array. Number at i == num-1. If this is violated anywhere, add i+1 to list.
Set: Add all numbers to set. Run a loop from 1 to n. If any number is missing, add to list
Count sort: sort all numbers such that num[i] == i-1. After sort, if any number violates, add to list
*/

/*
[4,3,2,7,8,2,3,1]
i = 0;
    nums[0] = 4
    7 == 4 => F
    index = 3
    temp = 7
    nums[3] = 4
    nums[0] = 7
    [7,3,2,4,8,2,3,1]
i = 0
    nums[0] = 7
    3 == 7 => F
    index = 6
    temp = 3
    nums[6] = 7
    nums[0] = 3
    [3,3,2,4,8,2,7,1]
i = 0
    nums[0] = 3
    2 == 3 => F
    index = 2
    temp = 2
    nums[2] = 3
    nums[0] = 2
    [2,3,3,4,8,2,7,1]
i = 0
    nums[0] = 2
    3 == 2 => F
    index = 1
    temp = 3
    nums[1] = 2
    nums[0] = 3
    [3,2,3,4,8,2,7,1]
i = 0
    nums[0] = 3
    3 == 3 => T
    i++
i = 1
    2 == 2 => T
    i++
    [3,2,3,4,8,2,7,1]
i = 2
    3 == 3 => T
    i++
    [3,2,3,4,8,2,7,1]
i = 3
    4 == 4 => T
    i++
    [3,2,3,4,8,2,7,1]
i = 4
    8 >= 8 => T
    i++
    [3,2,3,4,8,2,7,1]
i = 5
    nums[5] = 2
    index = 1
    nums[1] == 2 => T
    i++
    [3,2,3,4,8,2,7,1]
i = 6
    nums[6] == 7 => T
    i++
    [3,2,3,4,8,2,7,1]         
i = 7
    nums[0] == 1 => F
    index = 0
    temp = 3
    nums[0] = 1
    nums[7] = 3
    [1,2,3,4,8,2,7,3]
*/