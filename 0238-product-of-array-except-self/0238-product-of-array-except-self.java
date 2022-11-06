class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] product = new int[n];
        int count = 0;
        int prod = 1;
        for(int num: nums) {
            if(num == 0) {
                count++;
                continue;
            }
            prod *= num;
        }
        
        if(count > 1) {
            return new int[n];
        }
        
        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) {
                product[i] = prod;
            }
            else {
                product[i] = (count != 0) ? 0 : prod/nums[i];
            }
        }
        
        return product;
    }
}