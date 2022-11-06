class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return new int[0];
        }
        
        int n = nums.length;
        
        int[] product = new int[n];
        Arrays.fill(product, 1);
        
        for(int i = 0, pref = 1, suf = 1; i<n; i++) {
            product[i] *= pref;
            pref *= nums[i];
            product[n-1-i] *= suf;
            suf *= nums[n-i-1];
        }
        
        return product;
    }
}

/*
prefixProd = [1,1,2,6]
suffixProd = [24,12,4,1]
*/