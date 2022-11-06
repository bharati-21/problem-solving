class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList();
        
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int num = nums[i];
            int index = num - 1;
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
                duplicates.add(nums[i]);
            }
        }
        
        return duplicates;
    }
}

/*
[4,3,2,7,8,2,3,1]
[1,2,3,4,2,3,7,8]
*/