class Solution {
    public int countSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int index = -1;
        
        for(int i = 0; i<n; i++) {
            if(nums[i] == k) {
                index = i;
                break;
            }
        }
        // k not found (essentially this would never be the case)
        // since for an array of length n
        // there would be all numbers from 1 to n
        // and k is also 1 <= k <= n
        if(index == -1) return 0;
        
        Map<Integer, Integer> countDifferences = new HashMap();
        
        int lesser = 0, greater = 0;
        for(int i = index; i<n; i++) {
            int num = nums[i];
            if(num > k) {
                greater++;
            }
            else if(num < k) {
                lesser++;
            }
            
            int diff = (greater - lesser);
            countDifferences.put(diff, countDifferences.getOrDefault(diff, 0) + 1);
        }
        
        int count = 0;
        lesser = greater = 0;
        for(int i = index; i>=0; i--) {
            int num = nums[i];
            if(num > k) {
                greater++;
            }
            else if(num < k) {
                lesser++;
            }
            
            // 1 - (diff)
            // 1 - (greater - lesser)
            // 1 + lesser - greater
            // 0 - (greater - lesser)
            // 0 + lesser - greater
            int diff = greater - lesser;
            int oddLen = countDifferences.getOrDefault(-1*diff, 0);
            int evenLen = countDifferences.getOrDefault(1-diff, 0);
            count += (oddLen + evenLen);
        }
        
        return count;
    }
}

/*
observations:
1. All numbers are distinct, hence there will be only 1 k or no k
2. If there is no k, return 0
3. If there is a k, then use two pointers to find the left and right indices from k
[-1,-1,-1,0,1,1]
[-1,-2,-3,-3,-2,-1]
[-1,0,1,2,2,1]

[-2,-2,-2,-1,0,0]

[1,4,5] [-1,0,1]
[1,4,5,6] []
[4]
[4,5]
*/