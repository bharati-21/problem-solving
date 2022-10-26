class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        
        int[] prefix = new int[n+1];
        for(int i = 1; i<=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i<n; i++) {
            sum += nums[i];
            int remainder = sum % k;
            
            if(!map.containsKey(remainder) ) {
                map.put(remainder, i);
            }
            else {
                int j = map.get(remainder);
                if(i - j > 1) {
                    return true;
                }
            }
        }
//         Set<Integer> set = new HashSet();
//         for(int i = 2; i<=n; i++) {
//             int prevMod = prefix[i-2] % k;
//             set.add(prevMod);
//             int mod = prefix[i] % k;
//             if(set.contains(mod)) {
//                 return true;
//             }
//         }
//         return false;
        
        // for(int i = 0; i<n-1; i++) {
        //     for(int j = i+2; j<=n; j++) {
        //         if((prefix[j] - prefix[i]) % k == 0) {
        //             return true;
        //         }
        //     }
        // }
        
        return false;
    }
}
// 0 23 25 29 35 42