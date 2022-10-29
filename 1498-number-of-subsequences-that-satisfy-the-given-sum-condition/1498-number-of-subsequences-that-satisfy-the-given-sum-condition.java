class Solution {
    int mod = (int) (7 + Math.pow(10, 9));
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] pow = new int[n];
        pow[0] = 1;
        
        for(int i = 1; i<n; i++) {
            pow[i] = (pow[i-1] * 2) % mod;
        }
        
        int count = 0;
        for(int i = 0, j = n-1; i<=j;) {
            int left = nums[i];
            int right = nums[j];
            int sum = left + right;
            
            if(sum > target) {
                j--;
                continue;
            }
            int fact = j-i;
            count = (count + pow[fact]) % mod;
            i++;
        }
        
        return count % mod;
    }
}