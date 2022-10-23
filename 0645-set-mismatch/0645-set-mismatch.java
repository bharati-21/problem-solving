class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] missing = new int[2];
        
        if(nums == null || nums.length <= 1) {
            return missing;
        }
        
        int n = nums.length;
        
        int i = 0;
        while(i < n) {
            int num = nums[i];
            int index = num-1;
            if(nums[index] != num) {
                int temp = nums[index];
                nums[index] = num;
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
        
        i = 0;
        while(i < n) {
            int num = nums[i];
            if(i+1 != num) {
                missing[0] = num;
                missing[1] = i+1;
                break;
            }
            i++;
        }
        
        return missing;
    }
}

