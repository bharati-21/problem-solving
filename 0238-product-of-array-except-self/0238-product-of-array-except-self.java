class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] leftProduct = new int[n];
        
        int[] product = new int[n];
        
        leftProduct[0] = 1;
        
        int suffixProd = 1;
        for(int i = 1; i<n; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        
        for(int i = n-1; i>=0; i--) {
            product[i] = leftProduct[i] * suffixProd;
            suffixProd *= nums[i];
        }
        
        return product;
    }
}

/*
prefixProd = [1,1,2,6]
suffixProd = [24,12,4,1]
*/